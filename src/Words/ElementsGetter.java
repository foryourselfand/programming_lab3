package Words;

import Utils.Resettable;

public class ElementsGetter implements Resettable {
	private ElementGetter[] elementGetters;
	private IndexManipulator[] elementLengths;
	
	public ElementsGetter(ElementGetter[] elementGetters, IndexManipulator[] elementLengths) {
		this.elementGetters = elementGetters;
		this.elementLengths = elementLengths;
	}
	
	public String getElements() {
		assert this.elementGetters.length == this.elementLengths.length && this.elementGetters.length != 0;
		
		StringBuilder elements = new StringBuilder();
		for (int index = 0; index < this.elementGetters.length; index++) {
			
			int elementsLength = this.elementLengths[index].getIndex(this.elementGetters.length);
			for (int tempLength = 0; tempLength < elementsLength; tempLength++) {
				String elementTemp = this.elementGetters[index].getElement();
				elements.append(elementTemp);
			}
			elementGetters[index].reset();
		}
		return elements.toString();
	}
	
	@Override
	public void reset() {
		assert this.elementGetters.length == this.elementLengths.length && this.elementGetters.length != 0;
		for (int index = 0; index < elementGetters.length; index++){
			elementGetters[index].reset();
			elementLengths[index].reset();
		}
	}
}
