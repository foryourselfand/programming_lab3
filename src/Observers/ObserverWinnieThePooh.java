package Observers;

import Utils.Breath;
import Utils.Printable;

import java.util.HashMap;

public final class ObserverWinnieThePooh implements Printable {
	private Observable observable;
	private Breath breath;
	
	public ObserverWinnieThePooh(Observable observable, Breath breath) {
		this.observable = observable;
		this.breath = breath;
	}
	
	public ObserverWinnieThePooh(Observable observable) {
		this(observable, Breath.STRONG);
	}
	
	@Override
	public String getPrintableMessage() {
		return "Вздыхает: " + this.breath.getStrength();
	}
	
	public class MonitorMessage implements Observer {
		private String lastMessage;
		
		public MonitorMessage() {
			observable.addObserver(this);
		}
		
		@Override
		public String getPrintableMessage() {
			return "Сообщение: " + this.lastMessage;
		}
		
		@Override
		public void update(String message) {
			this.lastMessage = message;
		}
	}
	
	private abstract class Comparator implements Observer {
		protected boolean[] flags;
		protected int previousPattern;
		private int previousLength;
		
		public Comparator() {
			observable.addObserver(this);
			
			flags = new boolean[3];
			previousLength = - 1;
			previousPattern = 42;
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
		}
		
		@Override
		public String getPrintableMessage() {
			if (previousPattern == 42)
				return getMessageForFirstElementSituation();
			return getMessage();
		}
		
		public abstract String getMessageForFirstElementSituation();
		
		public abstract String getMessage();
	}
	
	public class Length extends Comparator {
		private HashMap<Integer, String> patternToName;
		
		public Length() {
			super();
			patternToName = new HashMap<>();
			patternToName.put(- 1, "меньше предыдущего");
			patternToName.put(0, "равен предыдущему");
			patternToName.put(1, "больше предыдущего");
		}
		
		@Override
		public String getMessageForFirstElementSituation() {
			return "Добавленный элемент не с чем сравнивать.";
		}
		
		@Override
		public String getMessage() {
			String currentState = patternToName.get(previousPattern);
			return "Добавленный элемент " +
					currentState +
					".";
		}
	}
	
	public class Sequence extends Comparator {
		@Override
		public String getMessageForFirstElementSituation() {
			return "Последовательность из единственного элемента.";
		}
		
		@Override
		public String getMessage() {
			StringBuilder allStateBuilder = new StringBuilder("Последовательность ");
			
			if (! flags[1]) {
				if (flags[0] && ! flags[2])
					allStateBuilder.append("убывающая");
				else if (! flags[0] && flags[2])
					allStateBuilder.append("возрастающая");
				else if (flags[0])
					allStateBuilder.append("чередующаяся");
			} else {
				if (flags[0] || flags[2])
					allStateBuilder.append("чередующаяся. C повторяющимися элементами");
				else
					allStateBuilder.append("монотонная");
			}
			
			allStateBuilder.append(".");
			return allStateBuilder.toString();
		}
	}
	
	public class MonitorBlank implements Observer {
		public MonitorBlank() {
			observable.addObserver(this);
		}
		
		@Override
		public String getPrintableMessage() {
			return "";
		}
		
		@Override
		public void update(String message) {
		}
	}
}
