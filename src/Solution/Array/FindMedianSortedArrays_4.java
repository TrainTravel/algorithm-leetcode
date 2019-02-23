package Solution.Array;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively, find the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 * nums1 and nums2 cannot be both empty.
 *
 * @author BorisMirage
 * Time: 2018/03/25 12:17
 * Created with IntelliJ IDEA
 */

public class FindMedianSortedArrays_4 {
    /**
     * Two arrays are both SORTED.
     * Add a virtual space in each array, for example:
     * [#, 1, #, 3, #, 6, #, 10, #, 11, #, 21, #]
     * In this way the median of this array will be (nums[(l + r) / 2] + nums[(l + r - 1) / 2]) / 2.
     * l = 0, r = nums.length.
     *
     * @param nums1 first sorted array with length m
     * @param nums2 second sorted array with length n
     * @return median of the two sorted arrays
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;

        if (l1 < l2) {
            return findMedianSortedArrays(nums2, nums1);        // assure num1 is longer array
        }

        /* left/right: left/right element next to median */
        double left1, right1, left2, right2;    // if array.length is odd, left == right, otherwise right - left == 1
        int l = 0, h = l2 * 2, vm1, vm2;        // avoid moving out of bound due to nums2 is shorter array

        while (l <= h) {
            vm2 = (h + l) / 2;        // mid of virtual array (nums2 * 2)
            vm1 = l1 + l2 - vm2;        // mid of virtual array (nums1 * 2)

            /* Avoid out of bound due to no overlapping between two arrays */
            left1 = (vm1 == 0) ? Integer.MIN_VALUE : nums1[(vm1 - 1) / 2];      // if l1 + l2 is odd, left1 == right1
            right1 = (vm1 == l1 * 2) ? Integer.MAX_VALUE : nums1[(vm1) / 2];    // else |left1 - right1| == 1

            /* Avoid out of bound due to second array is empty */
            left2 = (vm2 == 0) ? Integer.MIN_VALUE : nums2[(vm2 - 1) / 2];
            right2 = (vm2 == l2 * 2) ? Integer.MAX_VALUE : nums2[(vm2) / 2];

            /* Ensure L1 <= R2 && L2 <= R1 */
            if (left1 > right2) {
                l = vm2 + 1;
            } else if (right1 < left2) {
                h = vm2 - 1;
            } else {

                /* median: (max(L1, L2) + min(R1, R2)) / 2 */
                return (Math.max(left1, left2) + Math.min(right1, right2)) / 2;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        /* Find median Test */
        int[] num1 = {1, 2, 3};
        int[] num2 = {4, 5, 6};
        FindMedianSortedArrays_4 findMedianSortedArraysTest = new FindMedianSortedArrays_4();
        System.out.println(findMedianSortedArraysTest.findMedianSortedArrays(num1, num2));
    }
}