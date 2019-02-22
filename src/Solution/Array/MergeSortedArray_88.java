package Solution.Array;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * @author BorisMirage
 * Time: 2018/10/05 20:38
 * Created with IntelliJ IDEA
 */

public class MergeSortedArray_88 {
    /**
     * Two pointers.
     *
     * @param nums1 first array
     * @param m     first array's length
     * @param nums2 second array
     * @param n     second array's length
     */
    public void mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;      // nums1
        int j = n - 1;      // nums2
        int k = m + n - 1;      // num1 extra length
        while (i >= 0 && j >= 0) {      // two arrays are sorted, so start at the end
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
