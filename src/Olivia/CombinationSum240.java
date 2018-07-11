package Olivia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum240 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        combinationHelper(candidates, target, result, new ArrayList<Integer>(), 0);
        return result;
    }

    private void combinationHelper(int[] candidates, int target, List<List<Integer>> result, List<Integer> cur, int startLoc) {
        if (target > 0) {
            for (int i = startLoc; i < candidates.length; i++) {
                while (i > startLoc && i < candidates.length && candidates[i] == candidates[i - 1]) {
                    i++;
                }
                if (i == candidates.length) break;
                cur.add(candidates[i]);
                combinationHelper(candidates, target - candidates[i], result, cur, i + 1);
                cur.remove(cur.size() - 1);
            }

        } else if (target == 0) {
            result.add(new ArrayList<>(cur));
        }
    }
}
