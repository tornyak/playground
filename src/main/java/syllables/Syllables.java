package syllables;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
The number of syllables in the given word, according to
	 * this rule: Each contiguous sequence of one or more vowels is a syllable,
	 *       with the following exception: a lone "e" at the end of a word
	 *       is not considered a syllable unless the word has no other syllables.
	 *       You should consider y a vowel.
 */

public class Syllables {

    public static int getNumbSyllables (String word){
        boolean newSyllable=true;
        int result=0;

      String vowels = "aeiouy";
      char[] charWord = word.toCharArray();

        for (int i = 0; i < word.length(); i++) {

            if ((i==charWord.length-1) && Character.toLowerCase(charWord[i])=='e' && newSyllable && result>0) {
                result--;
            }

            if (newSyllable && vowels.indexOf(Character.toLowerCase(charWord[i]))>=0) {
                newSyllable=false;
                result++;
            }
            if (vowels.indexOf(Character.toLowerCase(charWord[i]))<0) {
                newSyllable=true;
            }
        }
        return result;
    }



    public static void main(String[] args) {
    int result;

    result=getNumbSyllables("obvious");
    System.out.println("Number of syllables is: "+result);
    }
}
