package Other.Monitors;

import Other.Displayable;

public class MonitorPrint extends Monitor {
	@Override
	public void display(Displayable displayable) {
		System.out.println(displayable.getDisplayableMessage());
	}
	
	@Override
	public void display(String message) {
	}
}
