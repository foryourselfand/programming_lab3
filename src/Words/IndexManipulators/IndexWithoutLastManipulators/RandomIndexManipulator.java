package Words.IndexManipulators.IndexWithoutLastManipulators;

import Utils.RandomHolder;
import Words.IndexManipulators.IndexManipulator;

public class RandomIndexManipulator extends IndexManipulator {
	@Override
	public int getIndex(int maxIndex) {
		return RandomHolder.getInstance().random.nextInt(maxIndex);
	}
}
