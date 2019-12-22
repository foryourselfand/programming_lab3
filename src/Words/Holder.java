package Words;

public class Holder {
	private ConditionFilter conditionFilter;
	private ElementFormatterSimple elementFormatterSimple;
	
	public Holder(ElementFormatterSimple elementFormatterSimple, ConditionFilter conditionFilter) {
		this.elementFormatterSimple = elementFormatterSimple;
		this.conditionFilter = conditionFilter;
	}
	
	public Holder(ElementFormatterSimple elementFormatterSimple) {
		this(elementFormatterSimple, index->true);
	}
	
	public Holder(ConditionFilter conditionFilter) {
		this(element->element, conditionFilter);
	}
	
	public Holder() {
		this(element->element, index->true);
	}
	
	public ConditionFilter getConditionFilter() {
		return conditionFilter;
	}
	
	public ElementFormatterSimple getElementFormatterSimple() {
		return elementFormatterSimple;
	}
}
