package Mirage.LeetCodeSolution;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 * It can be assumed that nums1 and nums2 cannot be both empty.
 *
 * @author BorisMirage
 * Time: 2018/03/25 12:17
 * Created with IntelliJ IDEA
 */

public class FindMedianSortedArrays_4 {
    /**
     * Two arrays are both SORTED.
     *
     * @param nums1 first sorted array with length m
     * @param nums2 second sorted array with length n
     * @return median of the two sorted arrays
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        if (length1 < length2) {
            return findMedianSortedArrays(nums2, nums1);        // assure num1 is larger array
        }

        int low = 0, high = length2 * 2;        // nums 2 is shorter array, ensure not move out of bound
        while (low <= high) {
            int mid2 = (high + low) / 2;
            int mid1 = length1 + length2 - mid2;

            double l1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1 - 1) / 2];
            double l2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2 - 1) / 2];
            double r1 = (mid1 == length1 * 2) ? Integer.MAX_VALUE : nums1[(mid1) / 2];
            double r2 = (mid2 == length2 * 2) ? Integer.MAX_VALUE : nums2[(mid2) / 2];

            if (l1 > r2) {
                low = mid2 + 1;
            } else if (r1 < l2) {
                high = mid2 - 1;
            } else {
                return (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
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