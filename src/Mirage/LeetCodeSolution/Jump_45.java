package Mirage.LeetCodeSolution;

/**
 * @author BorisMirage
 * Time: 2018/06/28 10:40
 * Created with IntelliJ IDEA
 */

public class Jump_45 {
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

        int start = 0;
        int end = 0;
        int curMax = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curMax = Math.max(curMax, nums[i] + i);
            if (i == end) {
                start++;
                end = curMax;
            }
        }
        return start;
    }

    public static void main(String[] args) {

        /* Jump_45 Game II */
        Jump_45 jumpTest = new Jump_45();
        int[] jump = {2, 3, 1, 1, 1};
        System.out.println("Min step: " + jumpTest.jump(jump));
        jump = new int[]{1, 3, 2};
        System.out.println("Min step: " + jumpTest.jump(jump));
        jump = new int[]{1, 1, 1, 1};
        System.out.println("Min step: " + jumpTest.jump(jump));
        jump = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 0};
        System.out.println("Min step: " + jumpTest.jump(jump));
        jump = new int[]{4, 1, 1, 3, 1, 1, 1};
        System.out.println("Min step: " + jumpTest.jump(jump));

    }
}
