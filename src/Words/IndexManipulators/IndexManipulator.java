package Words.IndexManipulators;

public abstract class IndexManipulator {
	protected int maxIndex;

	public int getIndex(int maxIndex) {
		this.maxIndex = maxIndex;
		return getIndex();
	}

	abstract public int getIndex();
}
