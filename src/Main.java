import Words.ConditionFilters.SequenseFilters.GreaterFilters.GreaterOrEqualsFilter;
import Words.ConditionFilters.SequenseFilters.LessFilters.LessFilter;
import Words.ElementFormatters.ReverseElementFormatter;
import Words.ElementFormatters.UpperElementFormatter;
import Words.ElementGetter;
import Words.ElementsFillers;
import Words.IndexManipulators.IndexWithLastManipulators.NextIndexManipulator;
import Words.IndexManipulators.IndexWithoutLastManipulators.FirstIndexManipulator;

public class Main {
	public static void main(String[] args) {
//		Owl owl = new Owl();
//		Him him = new Him(owl);
//
//		owl.setMessage("One");
//		owl.setMessage("Two");
//		owl.setMessage("Three");

		ElementGetter elementGetter = new ElementGetter(
				ElementsFillers.ENGLISH_ALPHABET_AND_SYLLABLES,
				new NextIndexManipulator(), new FirstIndexManipulator(),
				new UpperElementFormatter(new LessFilter(5)));

		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < 20; i++) {
			String element = elementGetter.getElement();
			stringBuilder.append(element);
		}
		System.out.println(stringBuilder);
	}
}
