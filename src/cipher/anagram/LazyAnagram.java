package cipher.anagram;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public interface LazyAnagram {

	public boolean isComplete();
	public List<LazyAnagram> getSuccessors();
	void forEach(Consumer<String> c);
	List<String> filter(Predicate<String> p);
}
