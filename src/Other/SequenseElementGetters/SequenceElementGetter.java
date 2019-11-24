package Other.SequenseElementGetters;

import Utils.RandomHolder;

public abstract class SequenceElementGetter {
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
		this(bound, 1, 1);
	}

	public int getNextIndex() {
		int indexToReturn = lastIndex;
		int absRandomDelay = RandomHolder.getInstance().random.nextInt(bound) + 1;
		int nextIndex = lastIndex + absRandomDelay * sign;
		if (nextIndex < 0)
			nextIndex = 0;
		lastIndex = nextIndex;
		return indexToReturn;
	}
}
