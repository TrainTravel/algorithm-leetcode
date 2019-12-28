package Playground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find all sub array that contains k elements, and their sum is exactly given target.
 *
 * @author BorisMirage
 * Time: 2019/11/05 14:46
 * Created with IntelliJ IDEA
 */

public class KSum {
    /**
     * Recursively remove one element in array until all k elements has been selected.
     * When k elements are selected, check if target equals to 0.
     *
     * @param nums   an integer array.
     * @param k      a positive integer (k <= length(A))
     * @param target a integer
     * @return a list of lists of integer
     */
    public List<List<Integer>> kSum(int[] nums, int k, int target) {

        List<List<Integer>> out = new ArrayList<>();

        /* Corner case */
        if (nums == null || nums.length == 0 || k == 0) {
            return out;
        }

        Arrays.sort(nums);
        backtracking(out, new ArrayList<>(), nums, k, target, 0);

        return out;
    }

    /**
     * Recursion.
     * Each round, remove one element in array and target is subtracted by this element.
     * If all k elements have been selected, check if current target equals to 0.
     * One optimize: if target is smaller than current element, it can not be the answer.
     *
     * @param out      final result
     * @param tmp      temporary list
     * @param arr      given array
     * @param k        k elements required
     * @param target   target number
     * @param position start position
     */
    private void backtracking(List<List<Integer>> out, List<Integer> tmp, int[] arr, int k, int target, int position) {

        if (k == 0 && target == 0) {
            out.add(new ArrayList<>(tmp));
            return;
        }

        if (k > 0 && target > 0) {
            for (int i = position; i < arr.length; i++) {
                if (arr[i] > target) {
                    return;
                }

                tmp.add(arr[i]);
                backtracking(out, tmp, arr, k - 1, target - arr[i], i + 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 7, 4, 5, 4, 6, 7, 2, 3, 4, 6, 7, 8, 7, 2, 2};
        KSum test = new KSum();
        System.out.println(test.kSum(arr, 3, 7));
    }
}
