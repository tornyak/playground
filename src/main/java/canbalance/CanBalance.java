package canbalance;

/*
Given a non-empty array, return true if there is a place to split the array
so that the sum of the numbers on one side is equal to the sum of the numbers on the other side.
canBalance([1, 1, 1, 2, 1]) → true
canBalance([2, 1, 1, 2, 1]) → false
canBalance([10, 10]) → true
 */

import java.util.Arrays;

public class CanBalance {

    public static boolean canBalance2(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(!(sum %2 == 0)) {
            return false;
        }
        if(sum == 0) {
            return true;
        }
        int halfSum = sum/2;
        int runningSum = 0;

        for(int i = 0; i < nums.length -1 && runningSum < halfSum; i++) {
            runningSum += nums[i];
            if(runningSum == halfSum) {
                return true;
            }
        }
        return false;
    }

//Tamara
public static boolean canBalance(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int sumLeft=0;
            int sumRight=0;
            for (int j = 0; j < nums.length; j++) {
                if (j<i) sumLeft+=nums[j];
                else sumRight+=nums[j];
            }
            if (sumLeft==sumRight) return true;
        }
        return false;
    }
}
