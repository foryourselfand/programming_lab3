package Other.Hims;

import Other.Breath;
import Other.Monitors.Monitor;
import Other.Monitors.MonitorNothing;
import Other.Observable;

public class HimMessandger extends Him {
	public HimMessandger(Observable observable, Breath breath, Monitor monitor) {
		super(observable, breath, monitor);
	}
	
	public HimMessandger(Observable observable, Breath breath) {
		this(observable, breath, new MonitorNothing());
	}
	
	public HimMessandger(Observable observable, Monitor monitor) {
		this(observable, Breath.STRONG, monitor);
	}
	
	public HimMessandger(Observable observable) {
		this(observable, Breath.STRONG, new MonitorNothing());
	}
	
	@Override
	public void updateByMessage(String message) {
	}
	
	@Override
	public String getDisplayableMessage() {
		return "Сообщение: " + lastMessage;
	}
}
