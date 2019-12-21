import Other.Monitors.Monitor;
import Other.Monitors.MonitorNothing;
import Other.Monitors.MonitorPrint;
import Other.Hims.HimLength;
import Other.Hims.HimMessandger;
import Other.Owl;
import Other.SequenseElementGetters.IncreasingSequenceGetter;
import Other.SequenseElementGetters.SequenceElementGetter;
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
		Owl owl = new Owl();
		
		Monitor printMonitor = new MonitorPrint();
		HimMessandger himMessandger = new HimMessandger(owl, printMonitor);
		
		System.out.println("Flag");
		System.out.println(himMessandger.getDisplayableMessage());
		
		HimLength himLength = new HimLength(owl, new MonitorNothing());
		
		ElementGetter wordGetter = new ElementGetter(
				ElementFillers.RUSSIAN_ALPHABET,
				new RandomIndexManipulator(),
				new UpperElementFormatter(new LessOrEqualsFilter(1)),
				new ReverseElementFormatter(new RandomHalfFilter())
		);
		ElementGetter endingGetter = new ElementGetter(
				ElementFillers.SYMBOLS_DEFAULT);
		FullWordGetter fullWordGetter = new FullWordGetter(wordGetter, endingGetter);
		
		SequenceElementGetter increasingSequence = new IncreasingSequenceGetter(5);
		WordsGetter wordsGetter = new WordsGetter(increasingSequence, fullWordGetter);
		for (int i = 0; i < 10; i++) {
			String fullWord = wordsGetter.getWord();
			owl.addMessage(fullWord);
		}
		printMonitor.display(himLength);
		
		String firstMessage = owl.getFirstMessage();
		System.out.println("Первое сообщение: " + firstMessage);
		owl.announceTheReader();
		
		System.out.println(himLength);
	}
}
