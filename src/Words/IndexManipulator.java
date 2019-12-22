package Words;

import Utils.RandomHolder;
import Utils.Resettable;

public interface IndexManipulator extends Resettable {
	int getIndex(int maxIndex);
	
	@Override
	default void reset() {
	}
	
	class First implements IndexManipulator {
		@Override
		public int getIndex(int maxIndex) {
			return 0;
		}
	}
	
	class Last implements IndexManipulator {
		@Override
		public int getIndex(int maxIndex) {
			return maxIndex - 1;
		}
	}
	
	class Random implements IndexManipulator {
		@Override
		public int getIndex(int maxIndex) {
			return RandomHolder.getInstance().random.nextInt(maxIndex);
		}
	}
	
	class Special implements IndexManipulator {
		private int specialIndex;
		
		public Special(int specialIndex) {
			if (specialIndex < 0)
				throw new IllegalArgumentException();
			this.specialIndex = specialIndex;
		}
		
		@Override
		public int getIndex(int maxIndex) {
			return specialIndex % maxIndex;
		}
	}
	
	abstract class WithLast implements IndexManipulator {
		protected int delay, lastIndex;
		private int delayStart;
		
		public WithLast(int delay) {
			this.delay = delay;
			this.delayStart = delay;
			
			this.lastIndex = 0;
		}
		
		public WithLast() {
			this(1);
		}
		
		@Override
		public void reset() {
			this.delay = this.delayStart;
			this.lastIndex = 0;
		}
		
		public void setLastIndex(IndexManipulator startIndexManipulator, int elements_length) {
			this.lastIndex = startIndexManipulator.getIndex(elements_length);
		}
	}
	
	class Next extends WithLast {
		public Next(int delay) {
			super(delay);
		}
		
		public Next() {
			super();
		}
		
		@Override
		public int getIndex(int maxIndex) {
			lastIndex += (delay % maxIndex);
			if (lastIndex >= maxIndex)
				lastIndex = lastIndex - maxIndex;
			return lastIndex;
		}
	}
	
	class Previous extends WithLast {
		public Previous(int delay) {
			super(delay);
		}
		
		public Previous() {
			super();
		}
		
		@Override
		public int getIndex(int maxIndex) {
			lastIndex -= (delay % maxIndex);
			if (lastIndex < 0)
				lastIndex = maxIndex + lastIndex;
			return lastIndex;
		}
	}
	
	class Sequence implements IndexManipulator {
		protected int bound, lastIndex, sign;
		private int boundStart, lastIndexStart, signStart;
		
		public Sequence(int bound, int startIndex, int sign) {
			this.boundStart = bound;
			this.lastIndexStart = startIndex;
			this.signStart = sign;
			this.reset();
		}
		
		public Sequence(int bound, int startIndex) {
			this(bound, startIndex, 1);
		}
		
		public Sequence(int bound) {
			this(bound, 1);
		}
		
		public Sequence() {
			this(1);
		}
		
		@Override
		public int getIndex(int maxIndex) {
			int indexToReturn = this.lastIndex;
			int absRandomDelay = RandomHolder.getInstance().random.nextInt(this.bound) + 1;
			int nextIndex = this.lastIndex + absRandomDelay * this.sign;
			if (nextIndex < 0)
				nextIndex = 0;
			this.lastIndex = nextIndex;
			return indexToReturn;
		}
		
		@Override
		public void reset() {
			bound = boundStart;
			lastIndex = lastIndexStart;
			sign = signStart;
		}
		
		public static class Increasing extends Sequence {
			public Increasing(int bound, int startIndex) {
				super(bound, startIndex, 1);
			}
			
			public Increasing(int bound) {
				super(bound, 1);
			}
			
			public Increasing() {
				super(1);
			}
		}
		
		public static class Decreasing extends Sequence {
			public Decreasing(int bound, int startIndex) {
				super(bound, startIndex, - 1);
			}
			
			public Decreasing(int bound) {
				this(bound, 42);
			}
			
			public Decreasing() {
				this(1);
			}
		}
	}
}

