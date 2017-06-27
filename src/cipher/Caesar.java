package cipher;

public class Caesar {

	public static String getShift(String text, int index) {
		String shifted = "";

		char[] letters = text.toCharArray();

		for (char letter : letters) {
			if (letter > 64 && letter < 91) {
				// upper case
				letter = (char) ((((letter - 65) + index) % 26) + 65);
			} else if (letter > 96 && letter < 122) {
				// lower case
				letter = (char) ((((letter - 97) + index) % 26) + 97);
			}
			shifted += letter;

		}
		return shifted;
	}

	public static String[] getAllShifts(String text) {
		String[] results = new String[26];
		for (int i = 0; i < 26; i++) {
			results[i] = getShift(text, i);
		}
		return results;
	}
}
