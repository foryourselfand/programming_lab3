import Other.Displays.Display;
import Other.Displays.EmptyDisplay;
import Other.Displays.PrintDisplay;
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

		Display printDisplay = new PrintDisplay();
		HimMessandger himMessandger = new HimMessandger(owl, printDisplay);
		HimLength himLength = new HimLength(owl, new EmptyDisplay());

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
		printDisplay.display(himLength.getDisplayableMessage());

		String firstMessage = owl.getFirstMessage();
		System.out.println("Первое сообщение: " + firstMessage);
		owl.announceTheReader();
	}
}
