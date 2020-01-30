package sumNumbers;

import org.junit.Test;

import static org.junit.Assert.*;
/*
Given a string, return the sum of the numbers appearing in the string,
ignoring all other characters. A number is a series of 1 or more digit chars in a row.
(Note: Character.isDigit(char) tests if a char is one of the chars '0', '1', .. '9'.
Integer.parseInt(string) converts a string to an int.)

sumNumbers("abc123xyz") → 123
sumNumbers("aa11b33") → 44
sumNumbers("7 11") → 18
 */

public class SumNumbersTest {

    @Test
    public void sumNumbers1() {
        String input="aa11b33";
        assertEquals(44,SumNumbers.sumNumbers(input));
    }
    @Test
    public void sumNumbers2() {
        String input="abc123xyz";
        assertEquals(123,SumNumbers.sumNumbers(input));
    }
    @Test
    public void sumNumbers3() {
        String input="7 11";
        assertEquals(18,SumNumbers.sumNumbers(input));
    }
    @Test
    public void sumNumbers4() {
        String input="a";
        assertEquals(0,SumNumbers.sumNumbers(input));
    }
    @Test
    public void sumNumbers5() {
        String input="7333";
        assertEquals(7333,SumNumbers.sumNumbers(input));
    }
}