package Dict;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Checker implements Comparator<String> {
	private boolean withSpaces;

	public Checker(boolean newSpaces) {
		this.withSpaces = newSpaces;
	}

	public void setSpaces(boolean newSpaces) {
		this.withSpaces = newSpaces;
	}

	@Override
	public int compare(String word1, String word2) {
		DictCheck dictionary = new DictCheck();

		return dictionary.percentMatches(word2, withSpaces) - dictionary.percentMatches(word1, withSpaces);

	}

	public Set over90(List<String> possibilities, boolean spaces) {
		Set<String> highCorrect = new LinkedHashSet<>();
		DictCheck dictionary =  new DictCheck();
		for (String text: possibilities) 
		{
			if (dictionary.percentMatches(text, spaces) >= 90) {
				highCorrect.add(text);
			}
		}
		return highCorrect;
	}
	
}
