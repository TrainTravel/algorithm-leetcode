package Olivia;

import java.util.*;

public class FourSum18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> cur = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {
                for (int j = 0; j < nums.length - 2; j++)
                    if ((j == i + 1) || (j > i + 1) && (nums[j] != nums[j - 1])) {
                        int startLoc = j + 1;
                        int endLoc = nums.length - 1;
                        while (startLoc < endLoc) {
                            int now = nums[i] + nums[j] + nums[startLoc] + nums[endLoc];
                            if (now == target) {
                                List<Integer> part = new ArrayList<>();
                            }
                        }
                    }
            }
        }

        // TODO: Complete this class. Return cur is temporary solution.
        return cur;
    }
}
