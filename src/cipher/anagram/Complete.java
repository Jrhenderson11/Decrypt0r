package cipher.anagram;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Complete implements LazyAnagram{

	String word;
	
	public Complete(String newWord) {
		this.word = newWord;
	}
	
	@Override
	public boolean isComplete() {
		return true;
	}

	@Override
	public List<LazyAnagram> getSuccessors() {
		
		return null;
	}

	@Override
	public void forEach(Consumer<String> c) {
		c.accept(word);
	}

	@Override
	public List<String> filter(Predicate<String> p) {
		List filtered = new ArrayList<LazyAnagram>();
		filtered.add(word);
		return filtered;
	}

}
