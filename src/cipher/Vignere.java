package cipher;

public class Vignere {

	public static String applyVignere(String text, String key, boolean encrypt) {
		key = key.toLowerCase();
		
		String res = "";
		
		String shifted = "";
		char[] letters = text.toCharArray();

		for (int i=0; i< letters.length; i++) {
			
			char letter =  letters[i];
			int shiftIndex = i % (key.length());
			char shiftLetter = key.toCharArray()[shiftIndex];
			int shiftNum = ((int) shiftLetter) - 96;
			
			//to decrypt make shift negative
			if (!encrypt) {
				shiftNum = 26-shiftNum;
			}
			char endLetter = 'a';
			
			if (letter > 64 && letter < 91) {
				// upper case
				endLetter = (char) ((((letter - 65) + shiftNum) % 26) + 65);
			} else if (letter > 96 && letter < 122) {
				// lower case
				endLetter = (char) ((((letter - 97) + shiftNum) % 26) + 97);
			}
			res+=endLetter;
			System.out.println("letter = " + letter + " shiftletter = " + shiftLetter + " shiftNum = " + shiftNum + " res = " + endLetter);
		}
			
		return res;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
