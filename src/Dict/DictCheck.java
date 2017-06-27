package Dict;

import java.util.HashSet;
import java.util.Set;

import utils.FileHandler;

public class DictCheck {

	private HashSet<String> wordSet;

	public DictCheck() {
		this.wordSet = new HashSet<String>();
	} 
	
	public int numMatches(String text) {
		// System.out.println("numMatch");
		// test the number of matches without spaces
		int num = 0;
		Set letterSet = new HashSet();

		String letters = "abcdefghijklmnopqrstuvwxyz1234567890";

		// go through every letter

		for (char letter : letters.toCharArray()) {
			String s = "" + letter;
			if (text.contains(s)) {
				letterSet.add(letter);
			}
		}

		for (int i = 0; i < text.length(); i++) {
			char l = text.toCharArray()[i];
			String letter = "" + l;

			if (letters.contains(letter)) {
				// go through each word in letter file
				// get substring
				String substring = text.substring(i);
				// check begins with word

			}

		}

		// files for each letter
		return num;
	}

	public int numWordMatches(String text) {
		// split
		String[] words = text.split(" ");
		int num = 0;

		for (String word : words) {
			if (wordExists(word)) {
				num++;
			}
		}
		return num;
	}

	public int percentMatches(String text, boolean withSpaces) {
		// get num words
		String[] words = text.split(" ");

		int numValid;
		if (withSpaces) {
			numValid = numWordMatches(text);
		} else {
			numValid = numMatches(text);
		}

		return ((numValid / words.length) * 100);
	}

	public boolean wordExists(String word) {
		if (this.wordSet == null || this.wordSet.isEmpty()) {
			loadWordSet();
		}
		return this.wordSet.contains(word);
	}

	private void loadWordSet() {
		this.wordSet =  new HashSet<>();
		FileHandler fileHandler = new FileHandler();
		String[] lines = fileHandler.readAllLines("res/british-english");
		
		for (String line : lines){
			this.wordSet.add(line);
		}
	}

}

