package Utils;

public enum Breath {
	WEAKLY("Слабо"),
	MEDIUM("Средне"),
	STRONG("Сильно");
	
	private String strength;
	
	Breath(String strength) {
		this.strength = strength;
	}
	
	public String getStrength() {
		return this.strength;
	}
}
