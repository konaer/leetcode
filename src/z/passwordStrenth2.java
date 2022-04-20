package z;

public class passwordStrenth2 {
	public static int find(String password) {

		int strenght = 0;
		String vowels = "aeoiu";
		char[] pass = password.toCharArray();
		boolean vowelC = false, consonantsC = false;

		for (int i = 0; i < pass.length; i++) {
			if (vowels.indexOf(pass[i]) != -1) {
				vowelC = true;
			} else {
				consonantsC = true;
			}

			if (vowelC && consonantsC) {
				strenght++;
				vowelC = consonantsC = false;
			}
		}
		return strenght;
	}
}

//Find the password strength.
//For each substring of the password which contains at least one vowel and one consonant, its strength goes up by 1.
//vowels={'a', 'e', 'i', 'o', 'u'}, and rest of letters are all consonant.
//(Only lower alphabet letters)
//
//Input:
//thisisbeautiful
//
//output:
//6
//
//explaination:
//this, is, be, aut, if, ul
//
//input:
//hackerrank
//
//output:
//3
//
//explaination:
//hack, er, rank
//
//input:
//aeiou
//
//output:
//0