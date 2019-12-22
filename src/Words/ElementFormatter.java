package Words;

public class ElementFormatter {
	private StringFormatter stringFormatter;
	private ConditionFilter conditionFilter;
	
	public ElementFormatter(StringFormatter stringFormatter, ConditionFilter conditionFilter) {
		this.stringFormatter = stringFormatter;
		this.conditionFilter = conditionFilter;
	}
	
	public ElementFormatter(StringFormatter stringFormatter) {
		this(stringFormatter, index->true);
	}
	
	public ElementFormatter(ConditionFilter conditionFilter) {
		this(element->element, conditionFilter);
	}
	
	public ElementFormatter() {
		this(element->element, index->true);
	}
	
	public String getFormattedElement(int index, String element) {
		if (conditionFilter.condition(index))
			return stringFormatter.getFormattedString(element);
		return element;
	}
}
