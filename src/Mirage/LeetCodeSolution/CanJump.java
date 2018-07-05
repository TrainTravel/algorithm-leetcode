package Mirage.LeetCodeSolution;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * Input array length will not be 0.
 *
 * @author BorisMirage
 * Time: 6/29/18 20:09
 * Created with IntelliJ IDEA
 */

public class CanJump {
    /**
     * To find max jump each time, it is needed to compare current move and next move.
     * Hence, if max jump results in a position that max length is 0, then this array can not reach the end of it.
     *
     * @param nums given int array that only contains non-negative int
     * @return if last index can be reached
     */
    public boolean canJump(int[] nums) {

        /* Special Case */
        if (nums.length < 2) {
            return true;
        }

        /* Start position in each step */
        int startIndex = 0;

        while (startIndex < nums.length) {

            if (startIndex > nums.length - 2) {
                return true;
            }
            if (nums[startIndex] == 0) {
                return false;
            }

            /* Set max move as maximum jump length at start position */
            int maxMove = startIndex + nums[startIndex];
            int nextStart = startIndex;

            /* If one step can move to the end of array, return true */
            if (maxMove > nums.length - 2) {
                return true;
            }

            /* Find max move distance based on current position */
            for (int i = startIndex + 1; i < nums.length && i <= nums[startIndex] + startIndex; i++) {

                /* Find longer moving distance */
                if (maxMove <= nums[i] + i) {
                    maxMove = nums[i] + i;
                    nextStart = i;
                }
            }
            startIndex = nextStart;
        }
        return false;
    }
}
