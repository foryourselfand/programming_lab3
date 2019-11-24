import Other.Displayers;
import Other.Hims.HimMessandger;
import Other.Owl;
import Other.SequenseElementGetters.IncreasingSequenceGetter;
import Other.SequenseElementGetters.SequenceElementGetter;
import Words.ConditionFilters.RandomFilter.RandomFilter;
import Words.ConditionFilters.RandomFilter.RandomHalfFilter;
import Words.ConditionFilters.SequenseFilters.LessFilters.LessOrEqualsFilter;
import Words.ElementFillers;
import Words.ElementFormatters.MultiplyRandomElementsFormatter;
import Words.ElementFormatters.ReverseElementFormatter;
import Words.ElementFormatters.UpperElementFormatter;
import Words.ElementGetter;
import Words.FullWordGetter;
import Words.IndexManipulators.IndexWithoutLastManipulators.RandomIndexManipulator;
import Words.WordsGetter;

public class Main {
	public static void main(String[] args) {
		Owl owl = new Owl();
		Displayers displayers = new Displayers();

		HimMessandger himMessandger = new HimMessandger(owl, displayers);

		owl.setMessage("One");
		displayers.displayAll();

		owl.setMessage("Two");
		displayers.displayAll();

		owl.setMessage("Three");
		displayers.displayAll();

		ElementGetter wordGetter = new ElementGetter(
				ElementFillers.ENGLISH_ALPHABET,
				new RandomIndexManipulator(),
				new UpperElementFormatter(new LessOrEqualsFilter(1)),
				new ReverseElementFormatter(new RandomHalfFilter())
		);
		ElementGetter endingGetter = new ElementGetter(
				ElementFillers.SYMBOLS_DEFAULT,
				new MultiplyRandomElementsFormatter(new RandomFilter(0.3f), 3)
		);
		FullWordGetter fullWordGetter = new FullWordGetter(wordGetter, endingGetter);

		SequenceElementGetter increasingSequence = new IncreasingSequenceGetter(5);
		WordsGetter wordsGetter = new WordsGetter(increasingSequence, fullWordGetter);
		for (int i = 0; i < 10; i++) {
			String fullWord = wordsGetter.getWord();
			System.out.println(fullWord);
		}
	}
}
