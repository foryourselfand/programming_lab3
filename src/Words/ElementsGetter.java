package Words;

import Utils.Resettable;

public class ElementsGetter implements Resettable {
	private ElementGetter[] elementGetters;
	private IndexManipulator[] elementLengths;
	private ElementFormatter elementsFormatter;
	
	public ElementsGetter(ElementGetter[] elementGetters, IndexManipulator[] elementLengths, ElementFormatter elementsFormatter) {
		this.elementGetters = elementGetters;
		this.elementLengths = elementLengths;
		this.elementsFormatter = elementsFormatter;
	}
	
	public ElementsGetter(ElementGetter[] elementGetters, IndexManipulator[] elementLengths) {
		this(elementGetters, elementLengths, new ElementFormatter());
	}
	
	public String getElements() {
		assert this.elementGetters.length == this.elementLengths.length && this.elementGetters.length != 0;
		
		StringBuilder elementsBuilder = new StringBuilder();
		for (int index = 0; index < this.elementGetters.length; index++) {
			
			int elementsLength = this.elementLengths[index].getIndex(this.elementGetters.length);
			for (int tempLength = 0; tempLength < elementsLength; tempLength++) {
				String elementTemp = this.elementGetters[index].getElement();
				elementsBuilder.append(elementTemp);
			}
			elementGetters[index].reset();
		}
		String elements = elementsBuilder.toString();
		elements = elementsFormatter.getFormattedElement(elementGetters.length, elements);
		return elements;
	}
	
	@Override
	public void reset() {
		assert this.elementGetters.length == this.elementLengths.length && this.elementGetters.length != 0;
		for (int index = 0; index < elementGetters.length; index++) {
			elementGetters[index].reset();
			elementLengths[index].reset();
		}
	}
}
