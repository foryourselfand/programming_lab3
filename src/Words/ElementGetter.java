package Words;

import Words.ElementsFillers.ElementsFiller;
import Words.IndexManipulators.IndexManipulator;

public class ElementGetter {
	private String[] elements;
	private IndexManipulator indexManipulator;

	public ElementGetter(ElementsFiller elementsFiller, IndexManipulator indexManipulator) {
		this.elements = elementsFiller.getElements();
		this.indexManipulator = indexManipulator;
	}

	public String getElement() {
		return elements[indexManipulator.getIndex(elements.length)];
	}
}
