import Words.ElementFiller;
import Words.ElementGetter;
import Words.IndexManipulator;

public class Testing {
	public static void main(String[] args) {
		ElementGetter elementGetter = new ElementGetter(ElementFiller.NUMBERS,
				new IndexManipulator.Next(), new IndexManipulator.First()
		);
		
		for (int i = 0; i < 15; i++)
			System.out.println(elementGetter.getElement());
	}
}
