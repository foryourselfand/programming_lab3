package Other.Hims;

import Other.Displayable;
import Other.Displayers;
import Other.Observable;
import Other.Observer;

public abstract class Him implements Observer, Displayable {
	protected String lastMessage;

	public Him(Observable observable, Displayers displayers) {
		observable.addObserver(this);
		displayers.addDisplayable(this);
	}

	@Override
	public void update(String message) {
		lastMessage = message;
	}
}
