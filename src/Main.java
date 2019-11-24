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

public class Main {
	public static void main(String[] args) {
//		Owl owl = new Owl();
//		Him him = new Him(owl);
//
//		owl.setMessage("One");
//		owl.setMessage("Two");
//		owl.setMessage("Three");

		ElementGetter wordGetter = new ElementGetter(
				ElementFillers.RUSSIAN_ALPHABET_AND_SYLLABLES,
				new RandomIndexManipulator(),
				new UpperElementFormatter(new LessOrEqualsFilter(1)),
				new ReverseElementFormatter(new RandomHalfFilter())
		);
		ElementGetter endingGetter = new ElementGetter(
				ElementFillers.SYMBOLS_DEFAULT,
				new MultiplyRandomElementsFormatter(new RandomFilter(0.3f), 3)
		);
		FullWordGetter fullWordGetter = new FullWordGetter(wordGetter, endingGetter);
		for (int i = 2; i < 15; i++) {
			String full_word = fullWordGetter.getWord(i);
			System.out.println(full_word);
		}
	}
}
