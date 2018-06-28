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
                                part.add(nums[i]);
                                part.add(nums[j]);
                                part.add(nums[startLoc]);
                                part.add(nums[endLoc]);
                                cur.add(part);
                                while (startLoc < endLoc && nums[startLoc] == nums[startLoc + 1]) {
                                    startLoc++;
                                }
                                while (startLoc < endLoc && nums[endLoc] == nums[endLoc - 1]) {
                                    endLoc--;
                                }
                                startLoc++;
                                endLoc--;
                            } else if (now < target) {
                                startLoc++;
                            } else {
                                endLoc--;
                            }
                        }
                    }
            }
        }
        return cur;
    }
}