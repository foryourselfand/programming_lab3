import Utils.Monitors.Monitor;
import Utils.Monitors.MonitorPrint;
import Other.ObservableOwl;
import Other.ObserverWinnieThePooh;
import Utils.Breath;
import Utils.SequenceElementGetter;
import Words.ConditionFilters.RandomFilter.RandomHalfFilter;
import Words.ConditionFilters.SequenseFilters.LessFilters.LessOrEqualsFilter;
import Words.ElementFillers;
import Words.ElementFormatters.ReverseElementFormatter;
import Words.ElementFormatters.UpperElementFormatter;
import Words.ElementGetter;
import Words.FullWordGetter;
import Words.IndexManipulators.IndexWithoutLastManipulators.RandomIndexManipulator;
import Words.WordsGetter;

public class Main {
	public static void main(String[] args) {
		ObservableOwl observableOwl = new ObservableOwl();
		
		Monitor monitor = new MonitorPrint();
		
		ObserverWinnieThePooh observerWinnieThePooh = new ObserverWinnieThePooh(observableOwl, Breath.STRONG, monitor);
		ObserverWinnieThePooh.MonitorMessage monitorMessage = observerWinnieThePooh.new MonitorMessage(observableOwl);
		ObserverWinnieThePooh.Length length = observerWinnieThePooh.new Length(observableOwl);
		ObserverWinnieThePooh.Sequence sequence = observerWinnieThePooh.new Sequence(observableOwl);
		
		ElementGetter wordGetter = new ElementGetter(
				ElementFillers.RUSSIAN_ALPHABET,
				new RandomIndexManipulator(),
				new UpperElementFormatter(new LessOrEqualsFilter(1)),
				new ReverseElementFormatter(new RandomHalfFilter())
		);
		ElementGetter endingGetter = new ElementGetter(
				ElementFillers.SYMBOLS_DEFAULT
		);
		
		FullWordGetter fullWordGetter = new FullWordGetter(wordGetter, endingGetter);
		SequenceElementGetter increasingSequence = new SequenceElementGetter.Increasing(5);
		
		WordsGetter wordsGetter = new WordsGetter(increasingSequence, fullWordGetter);
		
		for (int i = 0; i < 10; i++) {
			String fullWord = wordsGetter.getWord();
			observableOwl.addMessage(fullWord);
		}
		monitor.display("");
		
		String firstMessage = observableOwl.getFirstMessage();
		String lastMessage = observableOwl.getLastMessage();
		
		monitor.display("Первое сообщение: " + firstMessage);
		monitor.display("Последнее сообщение: " + lastMessage);
		monitor.display("");
		
		observableOwl.announceReader();
	}
}
