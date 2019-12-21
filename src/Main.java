import Utils.Breath;
import Other.Monitors.Monitor;
import Other.Monitors.MonitorPrint;
import Other.ObservableOwl;
import Utils.SequenceElementGetter;
import Other.ObserverWinnieThePooh;
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
		
		Monitor monitorPrint = new MonitorPrint();
		ObserverWinnieThePooh observerWinnieThePooh = new ObserverWinnieThePooh(observableOwl, Breath.STRONG, monitorPrint);
		ObserverWinnieThePooh.MonitorMessage observerWinnieThePoohMonitorMessage = observerWinnieThePooh.new MonitorMessage(observableOwl);
		ObserverWinnieThePooh.Length observerWinnieThePoohMonitorLength = observerWinnieThePooh.new Length(observableOwl);
		
		ElementGetter wordGetter = new ElementGetter(
				ElementFillers.RUSSIAN_ALPHABET,
				new RandomIndexManipulator(),
				new UpperElementFormatter(new LessOrEqualsFilter(1)),
				new ReverseElementFormatter(new RandomHalfFilter())
		);
		ElementGetter endingGetter = new ElementGetter(
				ElementFillers.SYMBOLS_DEFAULT);
		FullWordGetter fullWordGetter = new FullWordGetter(wordGetter, endingGetter);
		
		SequenceElementGetter increasingSequence = new SequenceElementGetter.Increasing(5);
		WordsGetter wordsGetter = new WordsGetter(increasingSequence, fullWordGetter);
		for (int i = 0; i < 10; i++) {
			String fullWord = wordsGetter.getWord();
			observableOwl.addMessage(fullWord);
		}
		
		String firstMessage = observableOwl.getFirstMessage();
		monitorPrint.display("Первое сообщение: " + firstMessage);
		observableOwl.announceReader();
	}
}
