package Other.Hims;

import Other.Breath;
import Other.Displays.Display;
import Other.Displays.PrintDisplay;
import Other.Observable;

import java.util.HashMap;

public class HimLength extends Him {
	private boolean[] flags;
	private int previousLength;
	private int previousPattern;
	private HashMap<Integer, String> patternToName;

	public HimLength(Observable observable, Breath breath, Display display) {
		super(observable, breath, display);
		flags = new boolean[3];
		previousLength = -1;
		previousPattern = 42;

		patternToName = new HashMap<>();
		patternToName.put(-1, "меньше предыдущего");
		patternToName.put(0, "равен предыдущему");
		patternToName.put(1, "больше предыдущего");
	}

	public HimLength(Observable observable, Breath breath) {
		this(observable, breath, new PrintDisplay());
	}

	public HimLength(Observable observable, Display display) {
		this(observable, Breath.STRONG, display);
	}

	public HimLength(Observable observable) {
		this(observable, Breath.STRONG, new PrintDisplay());
	}

	@Override
	public void updateByMessage(String message) {
		int currentLength = message.length();

		if (previousLength != -1) {
			int currentPattern = Integer.compare(currentLength, previousLength);
			previousPattern = currentPattern;
			flags[currentPattern + 1] = true;
		}

		previousLength = currentLength;
	}

	@Override
	public String getDisplayableMessage() {
		if (previousPattern == 42)
			return "Последовательность из единственного элемента.";
		return getCurrentState() + getAllState();
	}

	private String getCurrentState() {
		String currentState = patternToName.get(previousPattern);
		return "Добавленный элемент " +
				currentState +
				".";
	}

	private String getAllState() {
		StringBuilder allStateBuilder = new StringBuilder(" Последовательность ");
		if (flags[0] && flags[2])
			allStateBuilder.append("чередующаяся");
		else if (flags[0] || flags[2]) {
			if (flags[0])
				allStateBuilder.append("убывающая");
			else
				allStateBuilder.append("возрастающая");
			if (flags[1])
				allStateBuilder.append(". С повторяющимися элементами");
		} else if (flags[1])
			allStateBuilder.append("монотонная");
		allStateBuilder.append(".");
		return allStateBuilder.toString();
	}
}
