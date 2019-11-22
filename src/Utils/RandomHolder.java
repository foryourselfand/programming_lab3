package Utils;

import java.util.Random;

public class RandomHolder {
	public Random random;
	private static RandomHolder instance;

	private RandomHolder() {
		random = new Random();
	}

	public static RandomHolder getInstance() {
		if (instance == null)
			instance = new RandomHolder();
		return instance;
	}
}
