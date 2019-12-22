import Other.ObservableOwl;
import Other.Observer;
import Other.ObserverWinnieThePooh;
import Utils.Breath;
import Utils.Monitors.Monitor;
import Utils.Monitors.MonitorPrint;
import Utils.SequenceElementGetter;
import Words.ConditionFilters.RandomFilter.RandomHalfFilter;
import Words.ConditionFilters.SequenseFilters.LessFilters.LessOrEqualsFilter;
import Words.ElementFillers;
import Words.ElementFormatters.ElementFormatter;
import Words.ElementGetter;
import Words.FullWordGetter;
import Words.IndexManipulators.IndexWithoutLastManipulators.RandomIndexManipulator;
import Words.WordsGetter;

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
		
		ElementGetter wordGetter = new ElementGetter(
				ElementFillers.RUSSIAN.ALPHABET,
				new RandomIndexManipulator(),
				new ElementFormatter.Upper(new LessOrEqualsFilter(1)),
				new ElementFormatter.Reverse(new RandomHalfFilter())
		);
		ElementGetter endingGetter = new ElementGetter(
				ElementFillers.SYMBOLS.DEFAULT
		);
		
		FullWordGetter fullWordGetter = new FullWordGetter(wordGetter, endingGetter);
		SequenceElementGetter increasingSequence = new SequenceElementGetter.Increasing(2, 1);
		
		WordsGetter wordsGetter = new WordsGetter(increasingSequence, fullWordGetter);
		
		List<Observer> observers = observableOwl.getObservers();
		for (int i = 0; i < 10; i++) {
			String fullWord = wordsGetter.getWord();
			observableOwl.addMessage(fullWord);
			for (Observer observer : observers)
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
