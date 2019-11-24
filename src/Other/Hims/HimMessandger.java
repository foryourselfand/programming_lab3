package Other.Hims;

import Other.Breath;
import Other.Displays.Display;
import Other.Displays.EmptyDisplay;
import Other.Observable;

public class HimMessandger extends Him {
	public HimMessandger(Observable observable, Breath breath, Display display) {
		super(observable, breath, display);
	}

	public HimMessandger(Observable observable, Breath breath) {
		this(observable, breath, new EmptyDisplay());
	}

	public HimMessandger(Observable observable, Display display) {
		this(observable, Breath.STRONG, display);
	}

	public HimMessandger(Observable observable) {
		this(observable, Breath.STRONG, new EmptyDisplay());
	}

	@Override
	public void updateByMessage(String message) {
	}

	@Override
	public String getDisplayableMessage() {
		return "Сообщение: " + lastMessage;
	}
}
