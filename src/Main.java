import Words.ElementGetter;
import Words.ElementsFillers.SymbolsElementsFiller;
import Words.IndexManipulators.RandomIndexManipulator;

public class Main {
	public static void main(String[] args) {
		ElementGetter elementGetter = new ElementGetter(new SymbolsElementsFiller(), new RandomIndexManipulator());
		for (int i = 0; i < 10; i++) {
			System.out.print(elementGetter.getElement() + " ");
		}
	}
}
