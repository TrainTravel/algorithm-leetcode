package Olivia;

class Search35 {
    public int searchInsert(int[] nums, int target) {
        int startLoc = 0;
        int endLoc = nums.length - 1;
        while (startLoc <= endLoc) {
            int cur = (startLoc + endLoc) / 2;
            if (nums[cur] == target)
                return cur;
            if (nums[cur] > target)
                endLoc = cur - 1;
            else
                startLoc = cur + 1;
        }
        int cur = (startLoc + endLoc) / 2;
        if (nums[cur] < target)
            return cur + 1;
        if (nums[cur] > target && cur != 0) {
            return cur - 1;
        } else
            return 0;
    }
}