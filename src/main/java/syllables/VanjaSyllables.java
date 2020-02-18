package syllables;

public class VanjaSyllables {
    /**
     * To count the number of syllables in a word, it uses the following rules:
     *       Each contiguous sequence of one or more vowels is a syllable,
     *       with the following exception: a lone "e" at the end of a word
     *       is not considered a syllable unless the word has no other syllables.
     *       You should consider y a vowel.
     * @param word
     * @return
     */
    private static final String vowels ="aeiouy";

    protected static int getNumbSyllables(String word) {
        if(word == null || word.isEmpty()) {
            return 0;
        }

        String w = word.toLowerCase();
        int result = 0;
        boolean inSyllable = false;
        for (int i = 0; i < w.length(); i++) {
            if(isVowel(w.charAt(i))) {
                if(!inSyllable) {
                    inSyllable=true;
                    result++;
                }
            } else {
                inSyllable=false;
            }
        }

        if(endsOnLoneE(w) && result > 1) {
            result--;
        }

        return result;
    }

    private static boolean endsOnLoneE(String w) {
        char lastChar = w.charAt(w.length() - 1);
        if(lastChar != 'e') {
            return false;
        }
        if(w.length() == 1) {
            return true;
        }
        char charBeforeLast = w.charAt(w.length() - 2);
        return !isVowel(charBeforeLast);
    }

    private static boolean isVowel(char c) {
        return vowels.indexOf(c) != -1;
    }

}
