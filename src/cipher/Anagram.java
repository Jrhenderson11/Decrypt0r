package cipher;

import java.util.ArrayList;
import java.util.List;

public class Anagram {

	public static List<String> getAllAnagrams(String input) {
		int number = input.length();
		int len = number;

		//factorially calculate size of arrays
		while (number != 0) {
			number -= 1;
			len = len * (number);
		}

		String[] strArr = new String[len];

		char[] letters = new char[number];
		letters = input.toCharArray();

		ArrayList<Character> charList = new ArrayList<Character>();

		for (char l : letters) {
			charList.add(l);
		}

		// dictionary

		return recurseAnag("", charList);
	}

	private static List<String> recurseAnag(String start, List<Character> letters) {
		ArrayList<String> permutations = new ArrayList<String>();

		if (letters.size() == 0) {
			// error case
			permutations.add("Error: empty word");

		} else if (letters.size() == 1) {
			// base case
			permutations.add(Character.toString(letters.get(0)));
		} else {

			for (int i = 0; i < letters.size(); i++) {
				Character first = letters.get(i);
				// then get rest
				// letters.subList(1, (letters.size()));
				List<Character> chars = new ArrayList<Character>();
				chars.addAll(letters.subList(0, i));
				chars.addAll(letters.subList(i + 1, letters.size()));
				permutations = (ArrayList<String>) recurseAnag((start + first), chars);

			}
		}
		return permutations;
	}

}
