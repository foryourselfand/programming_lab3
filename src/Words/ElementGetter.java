package Words;

import Words.IndexManipulators.IndexManipulator;

public class ElementGetter {
	private String[] elements;
	private IndexManipulator indexManipulator;

	public ElementGetter(String[] elements, IndexManipulator indexManipulator) {
		this.elements = elements;
		this.indexManipulator = indexManipulator;
	}

	public String getElement() {
		return elements[indexManipulator.getIndex(elements.length)];
	}
}
