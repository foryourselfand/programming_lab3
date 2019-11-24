import Words.ElementGetter;
import Words.ElementsFillers;
import Words.IndexManipulators.SpecialIndexManipulator;

public class Main {
	public static void main(String[] args) {
//		Owl owl = new Owl();
//		Him him = new Him(owl);
//
//		owl.setMessage("One");
//		owl.setMessage("Two");
//		owl.setMessage("Three");

		ElementGetter elementGetter = new ElementGetter(
				ElementsFillers.NUMBERS,
				new SpecialIndexManipulator(-1));

		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < 21; i++) {
			String element = elementGetter.getElement();
			stringBuilder.append(element);
		}
		System.out.println(stringBuilder);
	}
}
