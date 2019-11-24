package Other.SequenseElementGetters;

public class DecreasingSequenceGetter extends SequenceElementGetter {
	public DecreasingSequenceGetter(int bound, int startIndex) {
		super(bound, startIndex, -1);
	}

	public DecreasingSequenceGetter(int startIndex) {
		this(1, startIndex);
	}

	public DecreasingSequenceGetter() {
		this(1, 42);
	}
}
