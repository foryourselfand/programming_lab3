package Other.Hims;

import Other.Breath;
import Other.Displayable;
import Other.Monitors.Monitor;
import Other.Monitors.MonitorPrint;
import Other.Observable;
import Other.Observer;

import java.util.Arrays;

public abstract class Him implements Observer, Displayable {
	protected String lastMessage;
	private Monitor monitor;
	private Breath breath;
	private Displayable displayableBreath;
	
	public Him(Observable observable, Breath breath, Monitor monitor) {
		observable.addObserver(this);
		this.breath = breath;
		this.monitor = monitor;
		this.displayableBreath = new DisplayableBreath();
		breathe();
	}
	
	public Him(Observable observable, Breath breath) {
		this(observable, breath, new MonitorPrint());
	}
	
	public Him(Observable observable, Monitor monitor) {
		this(observable, Breath.STRONG, monitor);
	}
	
	public Him(Observable observable) {
		this(observable, Breath.STRONG, new MonitorPrint());
	}
	
	@Override
	public void update(String message) {
		lastMessage = message;
		updateByMessage(message);
		monitor.display(this);
	}
	
	public abstract void updateByMessage(String message);
	
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
		Him him = (Him) object;
		return this.lastMessage.equals(him.lastMessage) && this.monitor == him.monitor && this.breath == him.breath;
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
}
