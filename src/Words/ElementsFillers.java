package Words;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ElementsFillers {
	public static final String[] NUMBERS = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

	public static final String[] ENGLISH_VOWELS = new String[]{"a", "e", "i", "o", "u", "y"};
	public static final String[] ENGLISH_CONSONANTS = new String[]{"b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q", "r", "s", "t", "v", "w", "x", "z"};
	public static final String[] ENGLISH_ALPHABET = merge(ENGLISH_VOWELS, ENGLISH_CONSONANTS);

	public static final String[] RUSSIAN_VOWELS = new String[]{"а", "о", "и", "е", "ё", "э", "ы", "у", "ю", "я"};
	public static final String[] RUSSIAN_CONSONANTS = new String[]{"б", "в", "г", "д", "ж", "з", "й", "к", "л", "м", "н", "п", "р", "с", "т", "ф", "х", "ц", "ч", "ш", "щ"};
	public static final String[] RUSSIAN_ALPHABET = merge(RUSSIAN_VOWELS, RUSSIAN_CONSONANTS);

	public static String[] merge(String[]... lists_input) {
		List<String> list_result = new ArrayList<>();
		for (String[] list_temp : lists_input)
			list_result.addAll(Arrays.asList(list_temp));
		return list_result.toArray(new String[0]);
	}
}
