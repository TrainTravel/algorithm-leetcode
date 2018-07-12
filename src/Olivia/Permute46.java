package Olivia;

import java.util.ArrayList;
import java.util.List;

public class Permute46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteHelper(result, nums, new ArrayList<Integer>());
        return result;
    }

    private void permuteHelper(List<List<Integer>> result, int[] nums, List<Integer> cur) {
        if (cur.size() < nums.length) {
            for (int i = 0; i < nums.length; i++) {
                if (!cur.contains(nums[i])) {
                    cur.add(nums[i]);
                    permuteHelper(result, nums, cur);
                    cur.remove(cur.size() - 1);
                }
            }
        } else if (cur.size() == nums.length) {
            result.add(new ArrayList(cur));
        }
    }
}

