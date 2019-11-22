package Words.IndexManipulators;

public class LastIndexManipulator extends IndexManipulator {
	@Override
	public int getIndex() {
		return maxIndex - 1;
	}
}
