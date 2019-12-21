package Words;

import Words.ElementFormatters.DefaultElementFormatter;
import Words.ElementFormatters.ElementFormatter;
import Words.IndexManipulators.IndexManipulator;
import Words.IndexManipulators.IndexWithLastManipulators.IndexWithLastManipulator;
import Words.IndexManipulators.IndexWithoutLastManipulators.RandomIndexManipulator;

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
		this(elements, new RandomIndexManipulator(), elementFormatters);
	}
	
	public ElementGetter(String[] elements, IndexManipulator indexManipulator) {
		this(elements, indexManipulator, new DefaultElementFormatter());
	}
	
	public ElementGetter(String[] elements) {
		this(elements, new RandomIndexManipulator(), new DefaultElementFormatter());
	}
	
	public ElementGetter(String[] elements, IndexWithLastManipulator indexWithLastManipulator, IndexManipulator startIndexManipulator, ElementFormatter... elementFormatters) {
		this(elements, indexWithLastManipulator, elementFormatters);
		setStartIndexManipulator(startIndexManipulator);
	}
	
	public ElementGetter(String[] elements, IndexWithLastManipulator indexWithLastManipulator, IndexManipulator startIndexManipulator) {
		this(elements, indexWithLastManipulator);
		setStartIndexManipulator(startIndexManipulator);
	}
	
	public ElementGetter(String[] elements, IndexWithLastManipulator indexWithLastManipulator, ElementFormatter... elementFormatters) {
		this(elements, (IndexManipulator) indexWithLastManipulator, elementFormatters);
		setStartIndexManipulator(new RandomIndexManipulator());
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
