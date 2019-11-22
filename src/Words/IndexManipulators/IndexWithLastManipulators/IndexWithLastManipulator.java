package Words.IndexManipulators.IndexWithLastManipulators;

import Words.IndexManipulators.IndexManipulator;
import Words.IndexManipulators.RandomIndexManipulator;

public abstract class IndexWithLastManipulator extends IndexManipulator {
	protected int lastIndex;
	private IndexManipulator startIndexManipulator;

	public IndexWithLastManipulator(IndexManipulator startIndexManipulator) {
		this.lastIndex = -1;
		this.startIndexManipulator = startIndexManipulator;
	}

	public IndexWithLastManipulator() {
		this(new RandomIndexManipulator());
	}

	@Override
	public int getIndex(int maxIndex) {
		if (lastIndex == -1)
			lastIndex = startIndexManipulator.getIndex(maxIndex);
		return super.getIndex(maxIndex);
	}
}
