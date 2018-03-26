package LeetCodeSolution;


import java.time.OffsetDateTime;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 3/25/18
 * Time: 12:17
 */

class FindMedianSortedArrays {
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

        int[] mergeResult = merge(nums1, nums2);

        /* Check whether total length is odd or even */
        boolean isOdd = (mergeResult.length) % 2 == 1;

        double result;
        if (isOdd) {
            result = mergeResult[(mergeResult.length - 1) / 2];
        } else {
            result = (float) (mergeResult[mergeResult.length / 2] - mergeResult[mergeResult.length / 2 - 1]) / (float) 2 + (float) mergeResult[mergeResult.length / 2 - 1];
        }

        return result;
    }

    public int[] merge(int[] a1, int[] a2) {

        if (a1.length == 0) {
            return a2;
        }
        if (a2.length == 0) {
            return a1;
        }

        if (a1.length < a2.length) {
            int[] temp = a2;
            a2 = a1;
            a1 = temp;
        }

        int index1 = 0;
        int index2 = 0;
        int[] mergeArray = new int[a1.length + a2.length];

        for (int i = 0; i < mergeArray.length; i++) {

            if (index1 == a1.length) {
                mergeArray[i] = a2[index2];
                index2 += 1;
            } else if (index2 == a2.length) {
                mergeArray[i] = a1[index1];
                index1 += 1;
            } else {
                mergeArray[i] = Math.min(a1[index1], a2[index2]);
                if (mergeArray[i] == a1[index1]) {
                    index1 += 1;
                } else {
                    index2 += 1;
                }
            }
        }
        return mergeArray;
    }


    public static void main(String[] args) {
        FindMedianSortedArrays test = new FindMedianSortedArrays();
        int[] num1 = {1, 2};
        int[] num2 = {1, 1};
        System.out.println(test.findMedianSortedArrays(num1, num2));
    }
}