package Other.SequenseElementGetters;

public class IncreasingSequenceGetter extends SequenceElementGetter {
	public IncreasingSequenceGetter(int bound, int startIndex) {
		super(bound, startIndex, 1);
	}

	public IncreasingSequenceGetter(int startIndex) {
		this(1, startIndex);
	}

	public IncreasingSequenceGetter() {
		this(1, 1);
	}
}
