package Olivia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteUnique47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        permuteHelper(result, nums, new ArrayList<Integer>(),new boolean[nums.length]);
        return result;
    }

    private void permuteHelper(List<List<Integer>> result, int[] nums, List<Integer> cur,boolean[] use) {
        if (cur.size() < nums.length) {
            for (int i = 0; i < nums.length; i++) {
                if (use[i] == true || i > 0 && nums[i] == nums[i - 1] && use[i - 1] != true)
                    continue;
                    cur.add(nums[i]);
                    use[i] = true;
                    permuteHelper(result, nums, cur, use);
                    cur.remove(cur.size() - 1);
                    use[i] = false;

            }}
            else if(cur.size() == nums.length) {
                result.add(new ArrayList(cur));
            }
        }
    }
