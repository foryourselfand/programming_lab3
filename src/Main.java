import Other.ObservableOwl;
import Other.Observer;
import Other.ObserverWinnieThePooh;
import Utils.Breath;
import Utils.Monitors.Monitor;
import Utils.Monitors.MonitorPrint;
import Utils.RandomHolder;
import Utils.SequenceElementGetter;
import Words.Concrete.FullWordGetter;
import Words.Concrete.WordsGetter;
import Words.ConditionFilter;
import Words.ElementFiller;
import Words.ElementFormatter;
import Words.ElementGetter;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		Monitor monitor = new MonitorPrint();
		
		ObservableOwl observableOwl = new ObservableOwl();
		
		ObserverWinnieThePooh observerWinnieThePooh = new ObserverWinnieThePooh(observableOwl, Breath.STRONG);
		monitor.display(observerWinnieThePooh);
		monitor.display("");
		
		ObserverWinnieThePooh.MonitorMessage monitorMessage = observerWinnieThePooh.new MonitorMessage();
		ObserverWinnieThePooh.Length length = observerWinnieThePooh.new Length();
		ObserverWinnieThePooh.Sequence sequence = observerWinnieThePooh.new Sequence();
		ObserverWinnieThePooh.MonitorBlank monitorBlank = observerWinnieThePooh.new MonitorBlank();
		List<Observer> observersOwl = observableOwl.getObservers();
		
		ElementGetter wordGetter = new ElementGetter(
				ElementFiller.RUSSIAN.ALPHABET,
				(index)->RandomHolder.getInstance().random.nextInt(index),
				new ElementFormatter.Upper(new ConditionFilter() {
					@Override
					public boolean condition(int index) {
						return index <= 1;
					}
				}),
				new ElementFormatter.Reverse(index->0.5f <= RandomHolder.getInstance().random.nextFloat())
		);
		ElementGetter endingGetter = new ElementGetter(
				ElementFiller.SYMBOLS.DEFAULT
		);
		
		FullWordGetter fullWordGetter = new FullWordGetter(wordGetter, endingGetter);
		SequenceElementGetter increasingSequence = new SequenceElementGetter.Increasing(2, 1);
		
		WordsGetter wordsGetter = new WordsGetter(increasingSequence, fullWordGetter);
		
		for (int i = 0; i < 10; i++) {
			String fullWord = wordsGetter.getWord();
			observableOwl.addMessage(fullWord);
			for (Observer observer : observersOwl)
				monitor.display(observer);
		}
		
		String firstMessage = observableOwl.getFirstMessage();
		String lastMessage = observableOwl.getLastMessage();
		
		monitor.display("Первое сообщение: " + firstMessage);
		monitor.display("Последнее сообщение: " + lastMessage);
		monitor.display("");
		
		observableOwl.announceReader();
	}
}
