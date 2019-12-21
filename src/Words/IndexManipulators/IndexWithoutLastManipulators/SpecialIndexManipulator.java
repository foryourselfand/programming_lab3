package Words.IndexManipulators.IndexWithoutLastManipulators;

import Words.IndexManipulators.IndexManipulator;

public class SpecialIndexManipulator extends IndexManipulator {
	private int specialIndex;
	
	public SpecialIndexManipulator(int specialIndex) {
		if (specialIndex < 0)
			throw new IllegalArgumentException();
		this.specialIndex = specialIndex;
	}
	
	@Override
	public int getIndex(int maxIndex) {
		return specialIndex % maxIndex;
	}
}
