package maxSpan;


/*Consider the leftmost and righmost appearances of some value in an array.
We'll say that the "span" is the number of elements between the two inclusive.
A single value has a span of 1. Returns the largest span found in the given array.
(Efficiency is not a priority.)

maxSpan([1, 2, 1, 1, 3]) → 4
maxSpan([1, 4, 2, 1, 4, 1, 4]) → 6
maxSpan([1, 4, 2, 1, 4, 4, 4]) → 6
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxSpan {

    public static void main(String[] args) {

        int[] input = {1, 2, 1, 1, 3};
        System.out.println(maxSpan(input));
    }


    public static int maxSpan (int[] nums){
        int lastIndex=0;
        int max=0;

        for (int i = 0; i < nums.length; i++) {
            lastIndex=i;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums [j])
                {
                    lastIndex=j;
                }
            }
            if ((lastIndex-i+1) > max) max=lastIndex-i+1;
        }
        return max;
    }
}



