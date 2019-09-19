package Solution.Array;

import java.util.HashMap;

/**
 * Given an array of integers and an integer k, find the total number of continuous sub arrays whose sum equals to k.
 *
 * @author BorisMirage
 * Time: 2019/09/19 10:23
 * Created with IntelliJ IDEA
 */

public class SubarraySum_560 {
    /**
     * Calculate the prefix sum and then find that if previous array contain the prefix that equals to current value.
     *
     * @param nums given int array
     * @param k    target number
     * @return total number of continuous sub arrays whose sum equals to k
     */
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> m = new HashMap<>();
        int out = 0;
        m.put(0, 1);        // if prefix sum + current value == target, then at least 1 sub array is found

        int prefix = 0;
        for (int i : nums) {
            prefix += i;      // calculate prefix sum

            /*
             * prefix - k:
             * Assume prefix from 0 to j has prefix, that sum(0, j) = prefix - k.
             * Then it means, the sub array sum from j to i is equal to k. */
            out += m.getOrDefault(prefix - k, 0);
            m.put(prefix, m.getOrDefault(prefix, 0) + 1);
        }

        return out;
    }
}
