package Solution.SlidingWindow;

/**
 * Given an array of n positive integers and a positive integer s.
 * Find the minimal length of a contiguous subarray of which the sum ≥ s.
 * If there isn't one, return 0 instead.
 *
 * @author BorisMirage
 * Time: 2019/06/18 16:11
 * Created with IntelliJ IDEA
 */

public class MinSubArrayLen_209 {
    /**
     * Two pointers, fast pointer locate the end of subarray where subarray's sum is larger than target.
     * When sum is larger than target, move the slow pointer to narrow length until find the shortest subarray.
     *
     * @param s    given target sum
     * @param nums given positive array
     * @return minimal length of a contiguous subarray of which the sum ≥ s
     */
    public int minSubArrayLen(int s, int[] nums) {
        int fast = 0, slow = 0, window = Integer.MAX_VALUE;
        int sum = 0;


        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            fast++;
            if (sum >= s) {
                while (sum >= s) {
                    sum -= nums[slow];
                    slow++;
                }
                window = Math.min(window, fast - slow + 1);
            }
        }

        return (window == Integer.MAX_VALUE) ? 0 : window;
    }

    public static void main(String[] args) {
        MinSubArrayLen_209 test = new MinSubArrayLen_209();
        System.out.println(test.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
}
