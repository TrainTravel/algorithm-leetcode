package Mirage.LeetCodeSolution;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 6/28/18
 * Time: 10:40
 */

public class Jump {
    /**
     * Given an array of non-negative integers, you are initially positioned at the first index of the array.
     * Each element in the array represents your maximum jump length at that position.
     * i.e., steps can be taken to move forward <= nums[i].
     * Your goal is to reach the last index in the minimum number of jumps.
     * <p>
     * Traverse all possible move distance in each step, find max move distance in each distance. (greedy algorithm)
     *
     * @param nums input int array
     * @return minimum number of jumps
     */
    public int jump(int[] nums) {

        /* Special Case */
        if (nums.length < 2) {
            return 0;
        }

        /* Start position in each step */
        int startIndex = 0;
        int minSteps = 0;

        while (startIndex < nums.length) {

            /* Set max move as maximum jump length at start position */
            int maxMove = startIndex + nums[startIndex];
            int nextStart = startIndex;

            /* If one step can move to the end of array, return this step */
            if (maxMove > nums.length - 2) {
                return minSteps + 1;
            }

            /* Find max move distance based on current position */
            for (int i = startIndex + 1; i < nums.length && i <= nums[startIndex] + startIndex; i++) {

                /* Find longer moving distance */
                if (maxMove < nums[i] + i) {
                    maxMove = nums[i] + i;
                    nextStart = i;
                }
            }
            startIndex = nextStart;
            minSteps++;
        }
        return minSteps;
    }
}
