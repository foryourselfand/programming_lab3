package Words.IndexManipulators.IndexWithLastManipulators;

import Words.IndexManipulators.IndexManipulator;

public class PreviousIndexManipulator extends IndexWithLastManipulator {
	public PreviousIndexManipulator(IndexManipulator startIndexManipulator) {
		super(startIndexManipulator);
	}

	public PreviousIndexManipulator() {
		super();
	}

	@Override
	public int getIndex() {
		int indexToReturn = lastIndex--;
		if (lastIndex == -1)
			lastIndex = maxIndex - 1;
		return indexToReturn;
	}
}
