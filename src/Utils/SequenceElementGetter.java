package Utils;

public class SequenceElementGetter {
	protected int bound;
	protected int lastIndex;
	protected int sign;
	
	public SequenceElementGetter(int bound, int startIndex, int sign) {
		this.bound = bound;
		this.lastIndex = startIndex;
		this.sign = sign;
	}
	
	public SequenceElementGetter(int bound, int startIndex) {
		this(bound, startIndex, 1);
	}
	
	public SequenceElementGetter(int bound) {
		this(bound, 1);
	}
	
	public SequenceElementGetter() {
		this(1);
	}
	
	public int getNextIndex() {
		int indexToReturn = this.lastIndex;
		int absRandomDelay = RandomHolder.getInstance().random.nextInt(this.bound) + 1;
		int nextIndex = this.lastIndex + absRandomDelay * this.sign;
		if (nextIndex < 0)
			nextIndex = 0;
		this.lastIndex = nextIndex;
		return indexToReturn;
	}
	
	public static class Increasing extends SequenceElementGetter {
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
	
	public static class Decreasing extends SequenceElementGetter {
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
