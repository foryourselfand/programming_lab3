package Words.IndexManipulators.IndexWithLastManipulators;

public class PreviousIndexManipulator extends IndexWithLastManipulator {
	public PreviousIndexManipulator(int delay) {
		super(delay);
	}
	
	public PreviousIndexManipulator() {
		super();
	}
	
	@Override
	public int getIndex(int maxIndex) {
		lastIndex -= (delay % maxIndex);
		if (lastIndex < 0)
			lastIndex = maxIndex + lastIndex;
		return lastIndex;
	}
}
