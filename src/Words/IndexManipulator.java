package Words;

import Utils.RandomHolder;

public interface IndexManipulator {
	int getIndex(int maxIndex);
	
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
		protected int lastIndex;
		protected int delay;
		
		public WithLast(int delay) {
			this.delay = delay;
		}
		
		public WithLast() {
			this(1);
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
}
