package Olivia;

public class Jump45 {
    public int jump(int[] nums) {
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
        return start;
    }
}
