package canbalance;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.*;
/*
Given a non-empty array, return true if there is a place to split the array
so that the sum of the numbers on one side is equal to the sum of the numbers on the other side.
canBalance([1, 1, 1, 2, 1]) → true
canBalance([2, 1, 1, 2, 1]) → false
canBalance([10, 10]) → true
*/

public class CanBalanceTest {

    @Test
    public void canBalance1() {
        int[] nums={1, 1, 1, 2, 1};
        assertEquals(true,CanBalance.canBalance(nums));
    }
    @Test
    public void canBalance2() {
        int[] nums={2, 1, 1, 2, 1};
        assertEquals(false,CanBalance.canBalance(nums));
    }
    @Test
    public void canBalance3() {
        int[] nums={10, 10};
        assertEquals(true,CanBalance.canBalance(nums));
    }
    @Test
    public void canBalance4() {
        int[] nums={1};
        assertEquals(false,CanBalance.canBalance(nums));
    }
    @Test
    public void canBalance5() {
        int[] nums={0,0};
        assertEquals(true,CanBalance.canBalance(nums));
    }

    @Test
    public void canBalanceBig() {
        int[] nums = IntStream.generate(() -> 1).limit(1_000_000).toArray();
        assertEquals(true,CanBalance.canBalance2(nums));
    }

}