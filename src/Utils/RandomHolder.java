package Utils;

import java.util.Random;

public class RandomHolder {
	private static RandomHolder instance;
	public Random random;
	
	private RandomHolder() {
		random = new Random();
	}
	
	public static RandomHolder getInstance() {
		if (instance == null)
			instance = new RandomHolder();
		return instance;
	}
}
