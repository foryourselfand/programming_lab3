package Words.IndexManipulators;

import Utils.RandomHolder;

public class RandomIndexManipulator extends IndexManipulator {
	@Override
	public int getIndex() {
		return RandomHolder.getInstance().random.nextInt(maxIndex);
	}
}
