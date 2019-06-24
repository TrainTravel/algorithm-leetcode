package Solution.BinarySearch;

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
     * Binary search.
     * Try to partition two arrays that sum of elements in two left part is equal to sum of elements in two right part.
     * The partition of both array should match the condition: maxLeft1 <= minRight2 && maxLeft2 <= minRight1.
     *
     * @param nums1 first sorted array with length m
     * @param nums2 second sorted array with length n
     * @return median of the two sorted arrays
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);        // assure nums1 is shorter array to avoid corner case
        }

        int left = 0, right = nums1.length;

        while (left <= right) {
            int middle1 = left + (right - left) / 2;       // binary search middle index
            int middle2 = (nums2.length + nums1.length + 1) / 2 - middle1;

            /*
             * maxLeft1 is the max value in left subarray of first array.
             * maxLeft2 is the max value in left subarray of second array.
             * minRight1 is the min value in right subarray of first array.
             * minRight2 is the min value in right subarray of second array.
             * Corner case: partition index reaches the end (or beginning) of array.
             * If reaches the end of array, then set to MAX_VALUE.
             * If reaches the beginning of array, set to MIN_VALUE
             * */
            int maxLeft1 = (middle1 == 0) ? Integer.MIN_VALUE : nums1[middle1 - 1];     // left of middle index
            int minRight1 = (middle1 == nums1.length) ? Integer.MAX_VALUE : nums1[middle1];     // middle index
            int maxLeft2 = (middle2 == 0) ? Integer.MIN_VALUE : nums2[middle2 - 1];     // left of middle index
            int minRight2 = (middle2 == nums2.length) ? Integer.MAX_VALUE : nums2[middle2];     // middle index

            /*
             * The condition for finding the median is that maxLeft1 <= minRight2 && maxLeft2 <= minRight1.
             * If so, the partition has already divide to parts that all left values are smaller than all right values.
             * If sum of two arrays are even, then return the average of median.
             * If sum of two arrays are odd, return the median.
             * If the condition is not met, then the partition position is incorrect,
             * If max in left subarray 1 is larger than min in right subarray 2, move partition position to left.
             * Since the partition has include elements that should belong to right sub array.
             * Otherwise, move partition position to right.
             * */
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                return ((nums1.length + nums2.length) % 2 == 0) ? ((double) Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2 : Math.max(maxLeft1, maxLeft2);
            } else if (maxLeft1 > minRight2) {
                right = middle1 - 1;
            } else {
                left = middle1 + 1;
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