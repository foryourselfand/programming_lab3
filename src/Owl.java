import java.util.LinkedList;
import java.util.List;

public class Owl implements Observable {
	private List<Observer> observers;
	private String message;

	public Owl() {
		observers = new LinkedList<>();
	}

	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update(message);
		}
	}

	public void setMessage(String message) {
		this.message = message;
		notifyObservers();
	}
}
