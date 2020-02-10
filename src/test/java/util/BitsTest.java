package util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BitsTest {

    @Test
    public void allBitsInZeroAreZero() {
        for (int i = 0; i < 32; i++) {
            assertEquals(0, Bits.get(0, i));
        }
    }

    @Test
    public void allBitsInMinusOneAreOne() {
        for (int i = 0; i < 32; i++) {
            assertEquals(1, Bits.get(-1, i));
        }
    }

    @Test
    public void negativeNumbersHaveBit31Set() {
        int[] numbers = {-1, -10, -1234567, Integer.MIN_VALUE};
        for(int num : numbers) {
            assertEquals(1, Bits.get(num, 31));
        }
    }
}