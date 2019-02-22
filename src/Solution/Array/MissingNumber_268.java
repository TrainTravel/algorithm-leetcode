package Solution.Array;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * Only one int is missing in int series.
 * If array contains elements from 0 to n-1, then return n.
 * <p>
 * Solution 1: Use HashSet.
 * Solution 2: Use bit manipulate.
 *
 * @author BorisMirage
 * Time: 2018/07/06 13:03
 * Created with IntelliJ IDEA
 */

public class MissingNumber_268 {
    /**
     * Put elements into set and traverse from 0 to n to find missing number.
     *
     * @param nums input int array
     * @return missing number
     */
    public int missingNumber(int[] nums) {

        /* Special Case */
        if (nums.length == 0) {
            return 0;
        }

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


    /**
     * Another solution for this problem without using HashSet.
     * Instead, this method uses bit manipulate.
     * Only one element is missing in 0, 1, 2, ..., n. And XOR operation has a principle a ^ b ^ b = a.
     * Hence, if array has all elements from 0 to n-1, then the XOR operation will finally back to initial value itself.
     * i.e, res ^ 1 ^ 1 ^ 2 ^ 2 ... ^ (n - 1) ^ (n - 1) = res.
     * If the missing int is in range [0, n], then res = res ^ missingIndex ^ n.
     * Since res initially is equal to n, finally res will be missing index, which is missing number.
     *
     * @param nums input int array
     * @return missing number
     */
    public int missingNumberWithBitManipulate(int[] nums) {

        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ i ^ nums[i];
        }
        return res;

    }
}
