package Other.Hims;

import Other.Breath;
import Other.Displayable;
import Other.Displays.Display;
import Other.Displays.PrintDisplay;
import Other.Observable;
import Other.Observer;

import java.util.Arrays;

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

	@Override
	public boolean equals(Object object) {
		if (this == object)
			return true;
		if (object == null)
			return false;
		if (this.getClass() != object.getClass())
			return false;
		Him him = (Him) object;
		return this.lastMessage.equals(him.lastMessage) && this.display == him.display && this.breath == him.breath;
	}

	@Override
	public int hashCode() {
		return Arrays.deepHashCode(new Object[]{lastMessage, display, breath});
	}

	@Override
	public String toString() {
		return "Him{" +
				"lastMessage='" + lastMessage + '\'' +
				", display=" + display +
				", breath=" + breath +
				'}';
	}
}
