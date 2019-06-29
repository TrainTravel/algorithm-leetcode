package Solution.Greedy;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * i.e., steps can be taken to move forward <= nums[i].
 * Your goal is to reach the last index in the minimum number of jumps.
 * Traverse all possible move distance in each step, find max move distance in each distance. (greedy algorithm)
 *
 * @author BorisMirage
 * Time: 2018/06/28 10:40
 * Created with IntelliJ IDEA
 */

public class Jump_45 {
    /**
     * Greedy, before each jump, find max next length in current available range.
     *
     * @param nums input int array
     * @return minimum number of jumps
     */
    public int jump(int[] nums) {

        int start = 0, end = 0, currentMax = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            currentMax = Math.max(currentMax, nums[i] + i);     // find max next length in current available range
            if (i == end) {
                start++;
                end = currentMax;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        Jump_45 jumpTest = new Jump_45();
        System.out.println("Min step: " + jumpTest.jump(new int[]{2, 3, 1, 1, 1}));
        System.out.println("Min step: " + jumpTest.jump(new int[]{1, 3, 2}));
        System.out.println("Min step: " + jumpTest.jump(new int[]{1, 1, 1, 1}));
        System.out.println("Min step: " + jumpTest.jump(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 0}));
        System.out.println("Min step: " + jumpTest.jump(new int[]{4, 1, 1, 3, 1, 1, 1}));
    }
}
