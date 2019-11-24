package Words.IndexManipulators;

public class LastIndexManipulator extends IndexManipulator {
	@Override
	public int getIndex(int maxIndex) {
		return maxIndex - 1;
	}
}
