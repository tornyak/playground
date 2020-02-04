package LongestWordDictionary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        String inputString = "abppplee";
        List<String> dictionary = new ArrayList<>(
                List.of("able", "ale", "apple", "bale", "kangaroo"));
        dictionary.sort(Comparator.comparingInt(String::length).reversed());

        dictionary.forEach(System.out::println);

        for (String s : dictionary) {
            char[] word = s.toCharArray();
            if (wordMatch(word, inputString)) {
                System.out.println("Match found: " + s);
                break;
            }
        }
    }

    private static boolean wordMatch(char[] word, String inputString) {
        int lastIndexInInput = 0;
        int index = -1;
        boolean match = false;

        for (char c : word) {
            index = inputString.indexOf(c, lastIndexInInput);
            if (index >= 0) lastIndexInInput = ++index;
            else break;
        }

        if (index >= 0) match = true;
        return match;
    }
}