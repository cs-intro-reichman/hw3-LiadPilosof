/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		//Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");

		System.out.println(randomAnagram("strertreertwerewrr"));
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		

		str1 = preProcess(str1);
		str2 = preProcess(str2);
		String temString="";

		if (str1.length() != str2.length()) {
			return false;
		}

		else for (int i = 0; i < str1.length(); i++) {
			for (int j = 0; j < str2.length(); j++) {
				if (str1.charAt(i)==str2.charAt(j)) {
					temString = str2.substring(0, j);
					if (i != str2.length()) {
						str2 = temString + str2.substring(j+1, str2.length());
					}
					else{
						str2 = temString;
					}
					
					break;
				}

			}
		}

		if (str2.length()!=0) {
			return false;
		}
	
		return true;
	}



	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		int length = str.length();
		String temString="";
		int ch =' ';
		for (int i = 0; i < length; i++) {
			if (str.charAt(i)==' ') {
				length--;
				temString = str.substring(0, i);
				if (i != str.length()) {
					str = temString + str.substring(i+1, str.length());
				}
			}
		}

		for (int i = 0; i < str.length(); i++) {
			 if (str.charAt(i)<=90&&str.charAt(i)>=65) {
			 	ch = str.charAt(i)+32;
			 	temString = str.substring(0, i)+(char)ch;
			 	if (i != str.length()) {
			 		str = temString + str.substring(i+1, str.length());
			 	}
			 }
		}

		return str;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		
		String newStr = "";
		int rand;

		while (str.length()>0) {
			rand = (int)(Math.random() * str.length());
			newStr = newStr + str.charAt(rand);
			str = str.substring(0, rand) + str.substring(rand+1);
				
		}

		return newStr;
	}
}
