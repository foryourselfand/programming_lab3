package Words;

import Words.IndexManipulators.IndexManipulator;
import Words.IndexManipulators.IndexWithLastManipulators.IndexWithLastManipulator;
import Words.IndexManipulators.RandomIndexManipulator;

public class ElementGetter {
	private String[] elements;
	private IndexManipulator indexManipulator;

	public ElementGetter(String[] elements, IndexManipulator indexManipulator) {
		this.elements = elements;
		this.indexManipulator = indexManipulator;
	}

	public ElementGetter(String[] elements) {
		this(elements, new RandomIndexManipulator());
	}

	public ElementGetter(String[] elements, IndexWithLastManipulator indexWithLastManipulator, IndexManipulator startIndexManipulator) {
		this(elements, indexWithLastManipulator);
		setStartIndexManipulator(startIndexManipulator);
	}

	public ElementGetter(String[] elements, IndexWithLastManipulator indexWithLastManipulator) {
		this(elements, (IndexManipulator) indexWithLastManipulator);
		setStartIndexManipulator(new RandomIndexManipulator());
	}

	public void setStartIndexManipulator(IndexManipulator startIndexManipulator) {
		if (indexManipulator instanceof IndexWithLastManipulator) {
			IndexWithLastManipulator indexWithLastManipulator = (IndexWithLastManipulator) indexManipulator;
			indexWithLastManipulator.setLastIndex(startIndexManipulator, elements.length);
		}
	}

	public String getElement() {
		return elements[indexManipulator.getIndex(elements.length)];
	}
}
