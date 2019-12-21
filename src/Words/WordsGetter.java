package Words;

import Utils.SequenceElementGetter;

public class WordsGetter {
	private SequenceElementGetter sequenceElementGetter;
	private FullWordGetter fullWordGetter;
	
	public WordsGetter(SequenceElementGetter sequenceElementGetter, FullWordGetter fullWordGetter) {
		this.sequenceElementGetter = sequenceElementGetter;
		this.fullWordGetter = fullWordGetter;
	}
	
	public String getWord() {
		int wordLength = sequenceElementGetter.getNextIndex();
		return fullWordGetter.getWord(wordLength);
	}
}
