package Utils.Monitors;

import Utils.Displayable;

public class MonitorPrint extends Monitor {
	@Override
	public void display(Displayable displayable) {
		System.out.println(displayable.getDisplayableMessage());
	}
	
	@Override
	public void display(String message) {
		System.out.println(message);
	}
}
