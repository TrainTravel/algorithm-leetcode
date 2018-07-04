package Olivia;

public class Jump55 {
    public boolean canJump(int[] nums) {
        int start = 0;
        int end = 0;
        int cur_max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            cur_max = Math.max(cur_max, nums[i] + i);
            if (i == end) {
                start++;
                end = cur_max;
            }
        }
        if (end < nums.length - 1)
            return false;
        else
            return true;
    }
}
