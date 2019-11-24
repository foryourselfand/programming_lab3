package Words.IndexManipulators.IndexWithoutLastManipulators;

import Words.IndexManipulators.IndexManipulator;

public class LastIndexManipulator extends IndexManipulator {
	@Override
	public int getIndex(int maxIndex) {
		return maxIndex - 1;
	}
}
