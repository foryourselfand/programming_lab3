package Other;

import Utils.RandomHolder;

import java.util.Arrays;
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
		System.out.format("Читать объявление будет: %s\n", randomReader);
	}

	@Override
	public boolean equals(Object object) {
		if (this == object)
			return true;
		if (object == null)
			return false;
		if (this.getClass() != object.getClass())
			return false;
		Owl owl = (Owl) object;
		return this.observers == owl.observers && this.messages == owl.messages && this.readers == owl.readers;
	}

	@Override
	public int hashCode() {
		return Arrays.deepHashCode(new Object[]{observers, messages, readers});
	}

	@Override
	public String toString() {
		return "Owl{" +
				"observers=" + observers +
				", messages=" + messages +
				", readers=" + Arrays.toString(readers) +
				'}';
	}
}
