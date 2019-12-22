package Words;

public class Holder {
	private StringFormatter stringFormatter;
	private ConditionFilter conditionFilter;
	
	public Holder(StringFormatter stringFormatter, ConditionFilter conditionFilter) {
		this.stringFormatter = stringFormatter;
		this.conditionFilter = conditionFilter;
	}
	
	public Holder(StringFormatter stringFormatter) {
		this(stringFormatter, index->true);
	}
	
	public Holder(ConditionFilter conditionFilter) {
		this(element->element, conditionFilter);
	}
	
	public Holder() {
		this(element->element, index->true);
	}
	
	public StringFormatter getStringFormatter() {
		return stringFormatter;
	}
	
	public ConditionFilter getConditionFilter() {
		return conditionFilter;
	}
}
