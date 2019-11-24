package Words;

public class FullWordGetter {
	private ElementGetter wordGetter;
	private ElementGetter endingGetter;

	public FullWordGetter(ElementGetter wordGetter, ElementGetter endingGetter) {
		this.wordGetter = wordGetter;
		this.endingGetter = endingGetter;
	}

	public String getWord(int length) {
		StringBuilder wordBuilder = new StringBuilder();
		for (int i = 0; i < length; i++) {
			String wordPart = wordGetter.getElement();
			wordBuilder.append(wordPart);
		}
		String endingPart = endingGetter.getElement();
		wordBuilder.append(endingPart);

		resetGetters();

		return wordBuilder.toString();
	}

	private void resetGetters() {
		wordGetter.reset();
		endingGetter.reset();
	}
}
