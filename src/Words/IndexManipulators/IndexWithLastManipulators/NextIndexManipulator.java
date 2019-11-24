package Words.IndexManipulators.IndexWithLastManipulators;

public class NextIndexManipulator extends IndexWithLastManipulator {
	public NextIndexManipulator(int delay) {
		super(delay);
	}

	public NextIndexManipulator() {
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
