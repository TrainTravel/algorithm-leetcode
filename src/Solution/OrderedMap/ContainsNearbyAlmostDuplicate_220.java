package Solution.OrderedMap;

import java.util.TreeSet;

/**
 * Given an array of integers.
 * Find out whether there are two distinct indices i and j in the array:
 * 1. Absolute difference between i and j is at most k.
 * 2. Absolute difference between nums[i] and nums[j] is at most t.
 *
 * @author BorisMirage
 * Time: 2019/06/13 14:21
 * Created with IntelliJ IDEA
 */

public class ContainsNearbyAlmostDuplicate_220 {
    /**
     * Tree set to save the value and keep size of tree set equals to k.
     * Find closest numbers in set and check if it is in the range of t.
     *
     * @param nums given array
     * @param k    largest absolute difference between i and j
     * @param t    largest absolute difference between nums[i] and nums[j]
     * @return whether there are two distinct indices i and j in the array satisfy the condition ofn k and t
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if (k < 1 || t < 0 || nums.length < 1) {
            return false;
        }

        TreeSet<Long> set = new TreeSet<>();        // use long to avoid overflow

        for (int i = 0; i < nums.length; i++) {

            /* Find closest value in set (use Long to avoid NullPointerException */
            Long floor = set.floor((long) nums[i]);       // greatest element in this set <= to the given element
            Long ceil = set.ceiling((long) nums[i]);       // least element in this set >= to the given element

            if ((floor != null && nums[i] - floor <= t) || (ceil != null && ceil - nums[i] <= t)) {
                return true;
            }

            set.add((long) nums[i]);

            if (i == k) {
                set.remove((long) nums[i - k]);     // keep size of set
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ContainsNearbyAlmostDuplicate_220 test = new ContainsNearbyAlmostDuplicate_220();

        System.out.println(test.containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
        System.out.println(test.containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
    }
}
