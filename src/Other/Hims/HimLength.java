package Other.Hims;

import Other.Breath;
import Other.Monitors.Monitor;
import Other.Monitors.MonitorPrint;
import Other.Observable;

import java.util.HashMap;

public class HimLength extends Him {
	private boolean[] flags;
	private int previousLength;
	private int previousPattern;
	private HashMap<Integer, String> patternToName;
	
	public HimLength(Observable observable, Breath breath, Monitor monitor) {
		super(observable, breath, monitor);
		flags = new boolean[3];
		previousLength = - 1;
		previousPattern = 42;
		
		patternToName = new HashMap<>();
		patternToName.put(- 1, "меньше предыдущего");
		patternToName.put(0, "равен предыдущему");
		patternToName.put(1, "больше предыдущего");
	}
	
	public HimLength(Observable observable, Breath breath) {
		this(observable, breath, new MonitorPrint());
	}
	
	public HimLength(Observable observable, Monitor monitor) {
		this(observable, Breath.STRONG, monitor);
	}
	
	public HimLength(Observable observable) {
		this(observable, Breath.STRONG, new MonitorPrint());
	}
	
	@Override
	public void updateByMessage(String message) {
		int currentLength = message.length();
		
		if (previousLength != - 1) {
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
