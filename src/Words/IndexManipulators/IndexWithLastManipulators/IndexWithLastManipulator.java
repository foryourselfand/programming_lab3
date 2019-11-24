package Words.IndexManipulators.IndexWithLastManipulators;

import Words.IndexManipulators.IndexManipulator;

public abstract class IndexWithLastManipulator extends IndexManipulator {
	protected int lastIndex;
	protected int delay;

	public IndexWithLastManipulator(int delay) {
		this.delay = delay;
	}

	public IndexWithLastManipulator() {
		this(1);
	}

	public void setLastIndex(IndexManipulator startIndexManipulator, int elements_length) {
		this.lastIndex = startIndexManipulator.getIndex(elements_length);
	}
}
