package Mirage.LeetCodeSolution;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 *
 * @author BorisMirage
 * Time: 2018/07/06 13:03
 * Created with IntelliJ IDEA
 */

public class MissingNumber {
    /**
     * Put elements into set and traverse from 0 to n to find missing number.
     *
     * @param nums input int array
     * @return missing number
     */
    public int missingNumber(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        for (int i = 0; i < nums.length; i++) {
            if (!numSet.contains(i)) {
                return i;
            }
        }
        return nums.length;
    }
}
