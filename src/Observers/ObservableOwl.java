package Observers;

import Utils.RandomHolder;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ObservableOwl implements Observable {
	private List<Observer> observers;
	private List<String> messages;
	private String[] readers;
	
	public ObservableOwl(String[] readers) {
		this.readers = readers;
		
		this.observers = new LinkedList<>();
		this.messages = new LinkedList<>();
	}
	
	public ObservableOwl() {
		this(new String[]{"Кристофер Робин"});
	}
	
	@Override
	public void addObserver(Observer observer) {
		this.observers.add(observer);
	}
	
	@Override
	public void removeObserver(Observer observer) {
		this.observers.remove(observer);
	}
	
	@Override
	public void notifyObservers() {
		String lastMessage = this.getLastMessage();
		for (Observer observer : this.observers) {
			observer.update(lastMessage);
		}
	}
	
	public List<Observer> getObservers() {
		return observers;
	}
	
	public void addMessage(String message) {
		this.messages.add(message);
		this.notifyObservers();
	}
	
	public String getFirstMessage() {
		return this.messages.get(0);
	}
	
	public String getLastMessage() {
		return this.messages.get(this.messages.size() - 1);
	}
	
	public void announceReader() {
		String randomReader = readers[RandomHolder.getInstance().random.nextInt(this.readers.length)];
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
		ObservableOwl other = (ObservableOwl) object;
		return this.observers == other.observers && this.messages == other.messages && this.readers == other.readers;
	}
	
	@Override
	public int hashCode() {
		return Arrays.deepHashCode(new Object[]{this.observers, this.messages, this.readers});
	}
	
	@Override
	public String toString() {
		return "ObservableOwl{" +
				"observers=" + this.observers +
				", messages=" + this.messages +
				", readers=" + Arrays.toString(this.readers) +
				'}';
	}
}
