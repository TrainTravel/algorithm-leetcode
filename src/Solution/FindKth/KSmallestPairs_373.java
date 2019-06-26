package Solution.FindKth;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 * Define a pair (u,v) which consists of one element from the first array and one element from the second array.
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 *
 * @author BorisMirage
 * Time: 2019/06/25 17:23
 * Created with IntelliJ IDEA
 */

public class KSmallestPairs_373 {
    /**
     * It can be regarded to a 2D matrix that contains the value is the sum of two elements in array.
     * Therefore, this problem can be converted to find k smallest elements in 2D matrix.
     *
     * @param nums1 first array
     * @param nums2 second array
     * @param k     k pairs with the smallest sums
     * @return k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> out = new ArrayList<>();

        /* Corner case */
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return out;
        }

        PriorityQueue<Tuple> q = new PriorityQueue<>();

        /*
         * Add sum of first element in nums1 (smallest in nums1) and each element in nums2.
         * Assume these values are smallest in array. */
        for (int j = 0; j < nums2.length; j++) {
            q.offer(new Tuple(0, j, nums1[0] + nums2[j]));
        }

        while (k-- > 0 && !q.isEmpty()) {

            /*
             * First polled element is nums1[0] + nums2[0]. This is smallest sum in two arrays.
             * Add nums1[1] + nums[0] to queue, based on heap comparator, it will be inserted to correct position.
             * Then poll the second smallest element in queue, and keep it until find k smallest pairs. */
            Tuple cur = q.poll();
            List<Integer> curList = new ArrayList<>();
            curList.add(nums1[cur.x]);
            curList.add(nums2[cur.y]);
            out.add(new ArrayList<>(curList));
            if (cur.x != nums1.length - 1) {
                q.offer(new Tuple(cur.x + 1, cur.y, nums1[cur.x + 1] + nums2[cur.y]));      // y is decided by polled element
            }
        }
        return out;
    }

    /**
     * Based on given index, save the sum of it.
     */
    class Tuple implements Comparable<Tuple> {
        int x, y, val;

        /**
         * @param x   index in array1
         * @param y   index in array2
         * @param val sum of two elements in array
         */
        Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        /**
         * @param b the other Tuple object
         * @return priority of two Tuples
         */
        @Override
        public int compareTo(Tuple b) {
            return this.val - b.val;        // Tuple with smaller sum is in prior of queue
        }
    }

}

