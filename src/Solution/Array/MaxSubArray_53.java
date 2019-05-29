package Solution.Array;


/**
 * @author BorisMirage
 * Time: 2018/06/29 19:34
 * Created with IntelliJ IDEA
 */

public class MaxSubArray_53 {
    /**
     * Given an integer array nums
     * Find the contiguous sub array (containing at least one number) which has the largest sum and return its sum.
     *
     * @param nums input int array
     * @return max contiguous sub array sum
     */
    public int maxSubArray(int[] nums) {

        /* Corner case */
        if (nums.length == 0) {
            return 0;
        }

        int maxSum = nums[0];
        int currentSum = 0;

        /* Iterate each element in array */
        for (int num : nums) {
            currentSum += num;
            maxSum = Integer.max(maxSum, currentSum);

            /* If current sum <= 0, then contiguous sub array sum ends here and max sum will exclude current element */
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    }
}
