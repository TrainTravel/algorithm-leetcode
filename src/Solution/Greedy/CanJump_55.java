package Solution.Greedy;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * Input array length will not be 0.
 *
 * @author BorisMirage
 * Time: 2018/06/29 20:09
 * Created with IntelliJ IDEA
 */

public class CanJump_55 {
    /**
     * Start from last to trace back if first can be reached.
     *
     * @param nums given int array that only contains non-negative int
     * @return if last index can be reached
     */
    public boolean canJump(int[] nums) {

        int last = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= last) last = i;
        }
        return last <= 0;
    }
}
