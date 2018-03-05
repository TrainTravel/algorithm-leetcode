package LeetCodeSolution;

/**
 * Created by borismirage on 2017/6/17.
 */
class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target - nums[i] == nums[j]) {
                    return new int[] {i,j};
                }
            }
        }
        throw new IllegalArgumentException("No solution. \n");
    }

    public static void main(String[] args) {
    }
}
