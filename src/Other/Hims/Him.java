package Other.Hims;

import Other.Breath;
import Other.Displayable;
import Other.Displays.Display;
import Other.Displays.PrintDisplay;
import Other.Observable;
import Other.Observer;

public abstract class Him implements Observer, Displayable {
	protected String lastMessage;
	private Display display;
	private Breath breath;

	public Him(Observable observable, Breath breath, Display display) {
		observable.addObserver(this);
		this.breath = breath;
		this.display = display;
		breathe();
	}

	public Him(Observable observable, Breath breath) {
		this(observable, breath, new PrintDisplay());
	}

	public Him(Observable observable, Display display) {
		this(observable, Breath.WEAKLY, display);
	}


	public Him(Observable observable) {
		this(observable, Breath.WEAKLY, new PrintDisplay());
	}

	@Override
	public void update(String message) {
		lastMessage = message;
		updateByMessage(message);
		display.display(getDisplayableMessage());
	}

	public abstract void updateByMessage(String message);

	public void breathe() {
		display.display("Он вздыхает " + breath.getStrength());
	}
}
