package Words;

import Utils.Exceptions.WrongIndexManipulatorStart;
import Utils.Resettable;

public class ElementGetter implements Resettable {
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
		this(elements, indexManipulator, new ElementFormatter());
	}
	
	public ElementGetter(String[] elements) {
		this(elements, new IndexManipulator.Random(), new ElementFormatter());
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
		IndexManipulator indexManipulatorStartNew = this.getIndexManipulatorStartHandle(indexManipulatorStart);
		
		IndexManipulator.WithLast indexManipulatorWithLast = (IndexManipulator.WithLast) this.indexManipulator;
		indexManipulatorWithLast.setLastIndex(indexManipulatorStartNew, elements.length);
		this.indexManipulator = indexManipulatorWithLast;
	}
	
	private IndexManipulator getIndexManipulatorStartCause(IndexManipulator indexManipulatorStart) {
		if (indexManipulatorStart instanceof IndexManipulator.WithLast)
			throw new WrongIndexManipulatorStart();
		return indexManipulatorStart;
	}
	
	private IndexManipulator getIndexManipulatorStartHandle(IndexManipulator indexManipulatorStart) {
		try {
			return this.getIndexManipulatorStartCause(indexManipulatorStart);
		} catch (WrongIndexManipulatorStart e) {
			if (indexManipulatorStart instanceof IndexManipulator.Next)
				return new IndexManipulator.First();
			else
				return new IndexManipulator.Last();
		}
	}
	
	public String getElement() {
		element_index++;
		String element = elements[indexManipulator.getIndex(this.elements.length)];
		for (ElementFormatter elementFormatter : elementFormatters)
			element = elementFormatter.getFormattedElement(element_index, element);
		return element;
	}
	
	@Override
	public void reset() {
		element_index = 0;
	}
}
