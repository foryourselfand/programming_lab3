package Other;

import Other.Monitors.Monitor;
import Other.Monitors.MonitorPrint;
import Utils.Breath;

import java.util.Arrays;
import java.util.HashMap;

public final class ObserverWinnieThePooh implements Observer, Displayable {
	private Monitor monitor;
	private String lastMessage;
	private Breath breath;
	private Displayable displayableBreath;
	
	public ObserverWinnieThePooh(Observable observable, Breath breath, Monitor monitor) {
		observable.addObserver(this);
		this.breath = breath;
		this.monitor = monitor;
		this.displayableBreath = new DisplayableBreath();
		this.breathe();
	}
	
	public ObserverWinnieThePooh(Observable observable, Breath breath) {
		this(observable, breath, new MonitorPrint());
	}
	
	public ObserverWinnieThePooh(Observable observable, Monitor monitor) {
		this(observable, Breath.STRONG, monitor);
	}
	
	public ObserverWinnieThePooh(Observable observable) {
		this(observable, Breath.STRONG, new MonitorPrint());
	}
	
	@Override
	public String getDisplayableMessage() {
		return "";
	}
	
	@Override
	public void update(String message) {
		this.lastMessage = message;
		monitor.display(this);
	}
	
	public void breathe() {
		this.monitor.display(this.displayableBreath);
	}
	
	@Override
	public boolean equals(Object object) {
		if (this == object)
			return true;
		if (object == null)
			return false;
		if (this.getClass() != object.getClass())
			return false;
		ObserverWinnieThePooh observerWinnieThePooh = (ObserverWinnieThePooh) object;
		return this.lastMessage.equals(observerWinnieThePooh.lastMessage) && this.monitor == observerWinnieThePooh.monitor && this.breath == observerWinnieThePooh.breath;
	}
	
	@Override
	public int hashCode() {
		return Arrays.deepHashCode(new Object[]{lastMessage, monitor, breath});
	}
	
	@Override
	public String toString() {
		return "Him{" +
				"lastMessage='" + lastMessage + '\'' +
				", display=" + monitor +
				", breath=" + breath +
				'}';
	}
	
	private class DisplayableBreath implements Displayable {
		@Override
		public String getDisplayableMessage() {
			return "Вздыхает: " + breath.getStrength();
		}
	}
	
	public class MonitorMessage implements Observer, Displayable {
		public MonitorMessage(Observable observable) {
			observable.addObserver(this);
		}
		
		@Override
		public void update(String message) {
			monitor.display(this);
		}
		
		@Override
		public String getDisplayableMessage() {
			return "Сообщение: " + lastMessage;
		}
	}
	
	public class Length implements Observer, Displayable {
		private boolean[] flags;
		private int previousLength;
		private int previousPattern;
		private HashMap<Integer, String> patternToName;
		
		public Length(Observable observable) {
			observable.addObserver(this);
			
			flags = new boolean[3];
			previousLength = - 1;
			previousPattern = 42;
			
			patternToName = new HashMap<>();
			patternToName.put(- 1, "меньше предыдущего");
			patternToName.put(0, "равен предыдущему");
			patternToName.put(1, "больше предыдущего");
		}
		
		@Override
		public void update(String message) {
			int currentLength = message.length();
			
			if (previousLength != - 1) {
				int currentPattern = Integer.compare(currentLength, previousLength);
				previousPattern = currentPattern;
				flags[currentPattern + 1] = true;
			}
			
			previousLength = currentLength;
			
			monitor.display(this);
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
}
