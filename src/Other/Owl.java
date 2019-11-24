package Other;

import Utils.RandomHolder;

import java.util.LinkedList;
import java.util.List;

public class Owl implements Observable {
	private List<Observer> observers;
	private List<String> messages;
	private String[] readers;

	public Owl(String[] readers) {
		this.observers = new LinkedList<>();
		this.messages = new LinkedList<>();
		this.readers = readers;
	}

	public Owl() {
		this(new String[]{"Кристофер Робин"});
	}

	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (Observer observer : observers)
			observer.update(messages.get(messages.size() - 1));
	}

	public void addMessage(String message) {
		this.messages.add(message);
		notifyObservers();
	}

	public String getFirstMessage() {
		return messages.get(0);
	}

	public void announceTheReader() {
		String randomReader = readers[RandomHolder.getInstance().random.nextInt(readers.length)];
		System.out.format("Читать объявление будет: %s", randomReader);
	}
}
