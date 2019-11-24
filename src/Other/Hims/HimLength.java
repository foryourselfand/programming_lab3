package Other.Hims;

import Other.Displayers;
import Other.Observable;

import java.util.HashMap;

public class HimLength extends Him {
	private int previousLength;
	private boolean[] flags;

	public HimLength(Observable observable, Displayers displayers) {
		super(observable, displayers);
		flags = new boolean[3];
		previousLength = -1;
	}

	@Override
	public void update(String message) {
		super.update(message);
		int currentLength = message.length();

		if (previousLength == -1) {
			int currentPattern = Integer.compare(currentLength, previousLength);
			flags[currentPattern + 1] = true;
		}

		previousLength = currentLength;
	}

	@Override
	public String display() {
		if (previousLength == -1)
			return "Последовательность из 1 элемента.";
		StringBuilder stringBuilder = new StringBuilder();

		return null;
	}

//	private String getCurrentState(){
//		if
//	}
}
