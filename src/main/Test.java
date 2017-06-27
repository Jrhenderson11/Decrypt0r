package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import Dict.Checker;
import cipher.Anagram;
import cipher.Caesar;
import cipher.Vignere;
import utils.Splitter;

public class Test {

	public static void main(String[] args) {

		Splitter splitter = new Splitter();
		splitter.SplitFile("res/british-english", "res/words");
		// ICSUDHPZCROMLXPCVK
		// ECGID
		// abcde fghijklmn opqrs
		//
		// System.out.println(Vignere.applyVignere("bcdefghijklmnopqrstuvwxyza",
		// "a", false));
		// String[] start = Caesar.getAllShifts("ICSUDHPZCROMLXPCVK");

		List<String> shifts = new ArrayList();

		for (String poss : Caesar.getAllShifts("")) {
			shifts.add(poss);
		}

		Checker sorter = new Checker(true);

		System.out.println("done");

		// Collections.sort(shifts, sorter);
		// Set<String> high = sorter.over90(shifts, true);

		System.out.println("correct:");
		for (String line : shifts) {
			System.out.println(line);
		}

		// System.out.println("total list:");
		// for (String line : shifts) {
		// System.out.println(line);
		// }

	}

}
