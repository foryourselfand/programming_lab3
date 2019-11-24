package Words;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ElementsFillers {
	public static final String[] NUMBERS = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

	public static final String[] ENGLISH_VOWELS = new String[]{"a", "e", "i", "o", "u", "y"};
	public static final String[] ENGLISH_CONSONANTS = new String[]{"b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q", "r", "s", "t", "v", "w", "x", "z"};
	public static final String[] ENGLISH_ALPHABET = merge(ENGLISH_VOWELS, ENGLISH_CONSONANTS);
	public static final String[] ENGLISH_SYLLABLES = new String[]{"aa", "ae", "ah", "ao", "aw", "ax", "ay", "ch", "dh", "ea", "eh", "er", "ey", "hh", "ia", "ih", "iy", "jh", "ng", "oh", "ow", "oy", "sh", "th", "ua", "uh", "uw", "zh"};
	public static final String[] ENGLISH_ALPHABET_AND_SYLLABLES = merge(ENGLISH_ALPHABET, ENGLISH_SYLLABLES);

	public static final String[] RUSSIAN_VOWELS = new String[]{"а", "о", "и", "е", "ё", "э", "ы", "у", "ю", "я"};
	public static final String[] RUSSIAN_CONSONANTS = new String[]{"б", "в", "г", "д", "ж", "з", "й", "к", "л", "м", "н", "п", "р", "с", "т", "ф", "х", "ц", "ч", "ш", "щ"};
	public static final String[] RUSSIAN_ALPHABET = merge(RUSSIAN_VOWELS, RUSSIAN_CONSONANTS);
	public static final String[] RUSSIAN_SYLLABLES = new String[]{"аб", "ав", "аг", "ад", "аж", "аз", "ай", "ак", "ал", "ам", "ан", "ап", "ар", "ас", "ат", "ац", "ач", "аш", "еб", "ев", "ед", "еж", "ез", "ек", "ел", "ем", "ен", "еп", "ер", "ес", "ет", "ец", "еч", "ёл", "зи", "иб", "ив", "иг", "из", "ик", "ил", "им", "ин", "ир", "ис", "ит", "иц", "ич", "ищ", "об", "ов", "ог", "од", "оз", "ой", "ок", "ол", "ом", "он", "оп", "ор", "ос", "от", "ох", "оч", "уб", "ув", "уг", "уд", "уж", "уз", "ук", "ул", "ум", "ун", "уп", "ур", "ус", "ут", "ух", "уч", "уш", "ыв", "ыр", "юд", "юл", "юр", "ют", "яв", "яз", "ял", "ян", "яр", "яс", "ят", "яц", "ящ"};
	public static final String[] RUSSIAN_ALPHABET_AND_SYLLABLES = merge(RUSSIAN_ALPHABET, RUSSIAN_SYLLABLES);


	public static String[] merge(String[]... lists_input) {
		List<String> list_result = new ArrayList<>();
		for (String[] list_temp : lists_input)
			list_result.addAll(Arrays.asList(list_temp));
		return list_result.toArray(new String[0]);
	}
}
