package Mirage.LeetCodeSolution;

/**
 * @author BorisMirage
 * Time: 2018/03/25 12:17
 * Created with IntelliJ IDEA
 */

public class FindMedianSortedArrays {
    /**
     * Two arrays are both SORTED.
     * The object is to find the median of the two sorted arrays.
     * The overall run time complexity should be O(log (m+n)).
     *
     * @param nums1 first sorted array with length m
     * @param nums2 second sorted array with length n
     * @return median of the two sorted arrays
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        /* If there is an empty array */
        if (nums1.length == 0) {
            return findMid(nums2);
        }
        if (nums2.length == 0) {
            return findMid(nums1);
        }

        int[] useArray = new int[nums1.length + nums2.length];
        boolean isOdd = (useArray.length) % 2 == 1;

        /* Make sure nums1 is longer array */
        if (nums1.length < nums2.length) {
            int[] temp = nums2;
            nums2 = nums1;
            nums1 = temp;
        }

        int index1 = 0;
        int index2 = 0;

        /* Find length is even or odd */
        for (int i = 0; i < useArray.length; i++) {
            if (index1 == nums1.length) {
                useArray[i] = nums2[index2];
                index2 += 1;
            } else if (index2 == nums2.length) {
                useArray[i] = nums1[index1];
                index1 += 1;
            } else {
                useArray[i] = Math.min(nums1[index1], nums2[index2]);
                if (useArray[i] == nums1[index1]) {
                    index1 += 1;
                } else {
                    index2 += 1;
                }
            }
            if (isOdd) {
                if (i == useArray.length / 2) {
                    return useArray[i];
                }
            } else {
                if (i == useArray.length / 2) {
                    return (float) (useArray[i] - useArray[i - 1]) / (float) 2 + useArray[i - 1];
                }
            }

        }
        throw new IllegalArgumentException("No solution. \n");
    }

    private double findMid(int[] a) {
        boolean isOdd = (a.length) % 2 == 1;
        double result;
        if (a.length == 1) {
            return a[0];
        } else if (a.length == 2) {
            return (float) (a[1] - a[0]) / (float) 2 + a[0];
        } else {
            if (isOdd) {
                result = a[a.length / 2];
            } else {
                result = (float) (a[a.length / 2] - a[a.length / 2 - 1]) / (float) 2 + a[a.length / 2 - 1];
            }
        }
        return result;
    }
}