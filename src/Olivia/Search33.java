package Olivia;

class Search33 {
    public int search(int[] nums, int target) {
        int startLoc = 0;
        int endLoc = nums.length - 1;

        while (startLoc <= endLoc) {
            int cur = (startLoc + endLoc) / 2;
            if (nums[cur] == target)
                return cur;
            if (nums[startLoc] <= nums[cur]) {
                if (target >= nums[startLoc] && target < nums[cur])
                    endLoc = cur - 1;
                else
                    startLoc = cur + 1;
            } else {
                if (target > nums[cur] && target <= nums[endLoc])
                    startLoc = cur + 1;
                else
                    endLoc = cur - 1;
            }
        }
        return -1;
    }
}
