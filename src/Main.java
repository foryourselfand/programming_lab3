import Other.Him;
import Other.Owl;
import Words.ElementGetter;
import Words.ElementsFillers;
import Words.IndexManipulators.RandomIndexManipulator;

public class Main {
	public static void main(String[] args) {
		Owl owl = new Owl();
		Him him = new Him(owl);

		owl.setMessage("One");
		owl.setMessage("Two");
		owl.setMessage("Three");

		ElementGetter elementGetter = new ElementGetter(ElementsFillers.ENGLISH_ALPHABET, new RandomIndexManipulator());
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			String element = elementGetter.getElement();
			stringBuilder.append(element);
		}
		System.out.println(stringBuilder);
	}
}
