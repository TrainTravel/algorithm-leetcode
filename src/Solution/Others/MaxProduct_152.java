package Solution.Others;

/**
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * @author BorisMirage
 * Time: 2019/02/21 09:54
 * Created with IntelliJ IDEA
 */

public class MaxProduct_152 {
    /**
     * Find max subarray, and find max min subarray, in case next int is negative and min becomes max.
     *
     * @param nums given array
     * @return max subarray product
     */
    public int maxProduct(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int maxPre = nums[0];
        int minPre = nums[0];
        int max = nums[0];
        int tempMax, tempMin;

        for (int i = 1; i < nums.length; i++) {

            /* Find current max value */
            tempMax = Math.max(Math.max(maxPre * nums[i], minPre * nums[i]), nums[i]);

            /* Find min subarray in case next value is negative so the product may become max */
            tempMin = Math.min(Math.min(maxPre * nums[i], minPre * nums[i]), nums[i]);

            max = Math.max(tempMax, max);
            maxPre = tempMax;
            minPre = tempMin;
        }

        return max;
    }
}
