package Utils;

import java.util.Random;

public class RandomHolder {
	private static RandomHolder instance;
	public Random random;
	
	private RandomHolder(long seed) {
		this.random = new Random(seed);
	}
	
	private RandomHolder() {
		this(new Random().nextLong());
	}
	
	public static RandomHolder getInstance() {
		if (RandomHolder.instance == null)
			RandomHolder.instance = new RandomHolder();
		return RandomHolder.instance;
	}
}
