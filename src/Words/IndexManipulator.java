package Words;

import Utils.RandomHolder;

public abstract class IndexManipulator {
	abstract public int getIndex(int maxIndex);
	
	public static class First extends IndexManipulator {
		@Override
		public int getIndex(int maxIndex) {
			return 0;
		}
	}
	
	public static class Last extends IndexManipulator {
		@Override
		public int getIndex(int maxIndex) {
			return maxIndex - 1;
		}
	}
	
	public static class Random extends IndexManipulator {
		@Override
		public int getIndex(int maxIndex) {
			return RandomHolder.getInstance().random.nextInt(maxIndex);
		}
	}
	
	public static class Special extends IndexManipulator {
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
	
	public static abstract class WithLast extends IndexManipulator {
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
	
	public static class Next extends WithLast {
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
	
	public static class Previous extends WithLast {
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
