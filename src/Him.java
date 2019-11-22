public class Him implements Observer {
	private String message;
	private Observable observable;

	public Him(Observable observable) {
		this.observable = observable;
		observable.registerObserver(this);
	}

	@Override
	public void update(String message) {
		this.message = message;
		display();
	}

	public void display() {
		System.out.printf("Message: %s\n", message);
	}
}
