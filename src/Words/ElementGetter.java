package Words;

import Words.IndexManipulators.IndexManipulator;

public class ElementGetter {
	private String[] elements;
	private ElementFormatter[] elementFormatters;
	private IndexManipulator indexManipulator;
	
	private int element_index;
	
	public ElementGetter(String[] elements, IndexManipulator indexManipulator, ElementFormatter... elementFormatters) {
		this.elements = elements;
		this.indexManipulator = indexManipulator;
		this.elementFormatters = elementFormatters;
		
		element_index = 0;
	}
	
	public ElementGetter(String[] elements, ElementFormatter... elementFormatters) {
		this(elements, new IndexManipulator.Random(), elementFormatters);
	}
	
	public ElementGetter(String[] elements, IndexManipulator indexManipulator) {
		this(elements, indexManipulator, new ElementFormatter.Default());
	}
	
	public ElementGetter(String[] elements) {
		this(elements, new IndexManipulator.Random(), new ElementFormatter.Default());
	}
	
	public ElementGetter(String[] elements, IndexManipulator.WithLast indexManipulatorWithLast, IndexManipulator indexManipulatorStart, ElementFormatter... elementFormatters) {
		this(elements, indexManipulatorWithLast, elementFormatters);
		setStartIndexManipulator(indexManipulatorStart);
	}
	
	public ElementGetter(String[] elements, IndexManipulator.WithLast indexManipulatorWithLast, IndexManipulator indexManipulatorStart) {
		this(elements, indexManipulatorWithLast);
		setStartIndexManipulator(indexManipulatorStart);
	}
	
	public ElementGetter(String[] elements, IndexManipulator.WithLast indexManipulatorWithLast, ElementFormatter... elementFormatters) {
		this(elements, (IndexManipulator) indexManipulatorWithLast, elementFormatters);
		setStartIndexManipulator(new IndexManipulator.Random());
	}
	
	public ElementGetter(String[] elements, IndexManipulator.WithLast indexWithLastManipulator) {
		this(elements, (IndexManipulator) indexWithLastManipulator);
		setStartIndexManipulator(new IndexManipulator.Random());
	}
	
	public void setStartIndexManipulator(IndexManipulator indexManipulatorStart) {
		if (indexManipulator instanceof IndexManipulator.WithLast) {
			IndexManipulator.WithLast indexWithLastManipulator = (IndexManipulator.WithLast) indexManipulator;
			indexWithLastManipulator.setLastIndex(indexManipulatorStart, elements.length);
		}
	}
	
	public String getElement() {
		element_index++;
		String element = elements[indexManipulator.getIndex(elements.length)];
		for (ElementFormatter elementFormatter : elementFormatters)
			if (elementFormatter.getCondition(element_index))
				element = elementFormatter.getFormattedElement(element);
		return element;
	}
	
	public void reset() {
		element_index = 0;
	}
}
