package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Splitter {

	public Map<Character, ArrayList<String>> getWordMap(String fileName) {
		Map<Character, ArrayList<String>> wordsMap = new HashMap<Character, ArrayList<String>>();
		FileHandler fileHandler = new FileHandler();
		// load all words
		String[] lines = fileHandler.readAllLines(fileName);

		for (String line : lines) {
			char startChar = line.toCharArray()[0];
			// start new list
			if (!wordsMap.containsKey(startChar)) {
				wordsMap.put(startChar, new ArrayList<String>());
			}

			// add to list
			wordsMap.get(startChar).add(line);

		}
		return wordsMap;
	}

	public void SplitFile(String readFile, String root) {
		Map<Character, ArrayList<String>> wordsMap = getWordMap(readFile);

		FileHandler fileHandler = new FileHandler();
		for (char startChar : wordsMap.keySet()) {
			String[] lines = new String[wordsMap.get(startChar).size()];
			for (int i=0; i<  wordsMap.get(startChar).size(); i++) {
				lines[i] = wordsMap.get(startChar).get(i);
			}
			String fileName = (root + "/" + startChar + "Words.txt");
			fileHandler.writeLines(fileName, lines);
		}
	}
}
