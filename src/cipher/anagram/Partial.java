package cipher.anagram;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Partial<T> implements LazyAnagram {

	private String start;
	private String rest;

	public Partial(String newStart, String newRest) {
		this.start = newStart;
		this.rest = newRest;
	}

	@Override
	public boolean isComplete() {
		return false;
	}

	@Override
	public List<LazyAnagram> getSuccessors() {
		List successors = new ArrayList<LazyAnagram>();

		if (this.rest.length() == 1) {
			// return list of completes
			for (char letter : rest.toCharArray()) {
				successors.add(new Complete(start + letter));
			}
		} else {
			// return partials
			for (int i = 0; i < rest.length(); i++) {
				char letter = rest.toCharArray()[i];
				String restWord = "";
				for (int j = 0; j < rest.length(); j++) {
					if (j != i) {
						restWord = restWord + rest.toCharArray()[j];
					}
				}
				successors.add(new Partial((start + letter), restWord));
			}

		}

		return successors;
	}

	@Override
	public void forEach(Consumer<String> c) {

	}

	@Override
	public List<String> filter(Predicate<String> p) {
		List filtered = new ArrayList<LazyAnagram>();
		for (LazyAnagram anagram : this.getSuccessors()) {
			filtered.addAll(anagram.filter(p));
			
		}
		return filtered;
	}

}
