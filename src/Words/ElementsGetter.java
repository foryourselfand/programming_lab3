package Words;

import Utils.Exceptions.LengthGreaterException;
import Utils.Exceptions.LengthLessException;
import Utils.Exceptions.LengthZeroException;
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
	
	public ElementsGetter(ElementGetter[] elementGetters) {
		this(elementGetters, new IndexManipulator[]{}, new ElementFormatter());
	}
	
	public String getElements() {
		this.exceptionsHandle();
		
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
	
	private void exceptionsCause() throws LengthZeroException, LengthGreaterException, LengthLessException {
		if (this.elementGetters.length == 0)
			throw new LengthZeroException();
		if (this.elementLengths.length > this.elementGetters.length)
			throw new LengthGreaterException();
		if (this.elementLengths.length < this.elementGetters.length)
			throw new LengthLessException();
	}
	
	private void exceptionsHandle() {
		try {
			this.exceptionsCause();
		} catch (LengthZeroException e) {
			e.printStackTrace();
			System.exit(42);
		} catch (LengthGreaterException e) {
			int lengthRequired = elementGetters.length;
			
			IndexManipulator[] elementLengthsRequired = new IndexManipulator[lengthRequired];
			System.arraycopy(this.elementLengths, 0, elementLengthsRequired, 0, lengthRequired);
			
			this.elementLengths = elementLengthsRequired;
			
		} catch (LengthLessException e) {
			int lengthCurrent = elementLengths.length;
			int lengthRequired = elementGetters.length;
			
			IndexManipulator[] elementLengthsRequired = new IndexManipulator[lengthRequired];
			
			System.arraycopy(this.elementLengths, 0, elementLengthsRequired, 0, lengthCurrent);
			for (int elementLengthIndex = lengthCurrent; elementLengthIndex < lengthRequired; elementLengthIndex++)
				elementLengthsRequired[elementLengthIndex] = new IndexManipulator.Special(1);
			
			this.elementLengths = elementLengthsRequired;
		}
	}
}
