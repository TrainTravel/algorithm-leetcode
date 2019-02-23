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
     * Add a virtual space in array, for example:
     * [#, 1, #, 3, #, 6, #, 10, #, 11, #, 21, #]
     * In this way the median of this array will be (nums[(l + r) / 2] + nums[(l + r - 1) / 2]) / 2.
     * l = 0, r = nums.length.
     *
     * @param nums1 first sorted array with length m
     * @param nums2 second sorted array with length n
     * @return median of the two sorted arrays
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        if (length1 < length2) {
            return findMedianSortedArrays(nums2, nums1);        // assure num1 is longer array
        }

        int low = 0, high = length2 * 2;        // avoid moving out of bound due to nums 2 is shorter array

        while (low <= high) {
            int mid2 = (high + low) / 2;        // mid of virtual array (nums2 * 2)
            int mid1 = length1 + length2 - mid2;        // mid of virtual array (nums1 * 2)

            /* Avoid out of bound due to no overlapping between two arrays */
            double left1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1 - 1) / 2];
            double right1 = (mid1 == length1 * 2) ? Integer.MAX_VALUE : nums1[(mid1) / 2];

            /* Avoid out of bound due to second array is empty */
            double left2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2 - 1) / 2];
            double right2 = (mid2 == length2 * 2) ? Integer.MAX_VALUE : nums2[(mid2) / 2];

            /* Ensure L1 <= R2 && L2 <= R1 */
            if (left1 > right2) {
                low = mid2 + 1;
            } else if (right1 < left2) {
                high = mid2 - 1;
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