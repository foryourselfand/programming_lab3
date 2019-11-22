package Words.IndexManipulators.IndexWithLastManipulators;

import Words.IndexManipulators.IndexManipulator;

public class NextIndexManipulator extends IndexWithLastManipulator {
	public NextIndexManipulator(IndexManipulator startIndexManipulator) {
		super(startIndexManipulator);
	}

	public NextIndexManipulator() {
	}

	@Override
	public int getIndex() {
		int indexToReturn = lastIndex++;
		if (lastIndex == maxIndex)
			lastIndex = 0;
		return indexToReturn;
	}
}
