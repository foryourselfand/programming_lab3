package Other.Hims;

import Other.Displayers;
import Other.Observable;

public class HimMessandger extends Him {
	public HimMessandger(Observable observable, Displayers displayers) {
		super(observable, displayers);
	}

	@Override
	public void update(String message) {
		super.update(message);
	}

	@Override
	public String display() {
		return "Message: " + lastMessage;
	}
}
