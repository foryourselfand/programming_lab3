package Words;

public class ElementGetter {
	private String[] elements;
	private Holder[] holders;
	private IndexManipulator indexManipulator;
	
	private int element_index;
	
	public ElementGetter(String[] elements, IndexManipulator indexManipulator, Holder... holders) {
		this.elements = elements;
		this.indexManipulator = indexManipulator;
		this.holders = holders;
		
		element_index = 0;
	}
	
	public ElementGetter(String[] elements, Holder... holders) {
		this(elements, new IndexManipulator.Random(), holders);
	}
	
	public ElementGetter(String[] elements, IndexManipulator indexManipulator) {
		this(elements, indexManipulator, new Holder(element->element, index->true));
	}
	
	public ElementGetter(String[] elements) {
		this(elements, new IndexManipulator.Random(), new Holder(element->element, index->true));
	}
	
	public ElementGetter(String[] elements, IndexManipulator.WithLast indexManipulatorWithLast, IndexManipulator indexManipulatorStart, Holder... holders) {
		this(elements, indexManipulatorWithLast, holders);
		setStartIndexManipulator(indexManipulatorStart);
	}
	
	public ElementGetter(String[] elements, IndexManipulator.WithLast indexManipulatorWithLast, IndexManipulator indexManipulatorStart) {
		this(elements, indexManipulatorWithLast);
		setStartIndexManipulator(indexManipulatorStart);
	}
	
	public ElementGetter(String[] elements, IndexManipulator.WithLast indexManipulatorWithLast, Holder... holders) {
		this(elements, (IndexManipulator) indexManipulatorWithLast, holders);
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
		for (Holder holder : holders)
			if (holder.getConditionFilter().condition(element_index))
				element = holder.getStringFormatter().getFormattedString(element);
		return element;
	}
	
	public void reset() {
		element_index = 0;
	}
}
