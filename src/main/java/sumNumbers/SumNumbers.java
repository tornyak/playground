package sumNumbers;

/*
Given a string, return the sum of the numbers appearing in the string,
ignoring all other characters. A number is a series of 1 or more digit chars in a row.
(Note: Character.isDigit(char) tests if a char is one of the chars '0', '1', .. '9'.
Integer.parseInt(string) converts a string to an int.)

sumNumbers("abc123xyz") → 123
sumNumbers("aa11b33") → 44
sumNumbers("7 11") → 18
 */
public class SumNumbers {

    //Vanja
    public static int sumNumbers(String str) {
        int result = 0;
        for(int i = 0; i <  str.length();) {
            int number = 0;
            for(int j = i; j < str.length() && Character.isDigit(str.charAt(j)); j++, i++) {
                number *= 10;
                number += Integer.parseInt(String.valueOf(str.charAt(j)));
            }
            result += number;
            i++;
        }
        return result;
    }
    /*
    //Tamara
    public static int sumNumbers(String str) {
        int sum=0;
        String temp="";

        for (int i = 0; i <str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                temp=temp+str.charAt(i);
                if (((i+1) < str.length()) && (!Character.isDigit(str.charAt(i+1))))
                   temp=temp+";";
            }
        }
        if (!temp.isEmpty()) {
            String[] numbers= temp.split(";");
            for (String s:numbers) {
                sum+=Integer.parseInt(s);
            }
        }
        return sum;
    }
     */
}
