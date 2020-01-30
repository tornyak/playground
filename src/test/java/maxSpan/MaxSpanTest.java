package maxSpan;
import org.junit.Test;

import java.lang.reflect.Array;

import static org.junit.Assert.assertEquals;

public class MaxSpanTest {

    /*
    maxSpan([1, 2, 1, 1, 3]) → 4
    maxSpan([1, 4, 2, 1, 4, 1, 4]) → 6
    maxSpan([1, 4, 2, 1, 4, 4, 4]) → 6
    */
    @Test
    public void maxSpan() {
        int[] input = {1, 2, 1, 1, 3};
        int[] input2 = {1, 4, 2, 1, 4, 1, 4};
        int[] input3 = {1, 4, 2, 1, 4, 4, 4};
        int[] input4 = {1};
        int[] input5 = new int [4];

        assertEquals (4,MaxSpan.maxSpan(input));
        assertEquals (6,MaxSpan.maxSpan(input2));
        assertEquals (6,MaxSpan.maxSpan(input3));
        assertEquals (1,MaxSpan.maxSpan(input4));
        //assertEquals (1,MaxSpan.maxSpan(input5));

    }
}