package Solution.FindKth;

import java.util.Random;

/**
 * Find the kth largest element in an unsorted array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * @author BorisMirage
 * Time: 2019/06/24 13:41
 * Created with IntelliJ IDEA
 */

public class FindKthLargest_215 {
    /**
     * Use partition to partition array until right side (larger side) has just k elements.
     *
     * @param nums given number
     * @param k    kth largest element
     * @return kth largest element in an unsorted array
     */
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int index = partition(nums, left, right);

            if (index - left + 1 < k) {
                k = k - (index - left + 1);
                left = index + 1;
            } else if (index - left + 1 > k) {
                right = index - 1;
            } else {
                return nums[index];
            }
        }
        return 0;
    }

    /**
     * Quick select.
     *
     * @param array given array
     * @param left  start position
     * @param right end position
     * @return partition array
     */
    private int partition(int[] array, int left, int right) {
        Random r = new Random();
        int pivotIndex = r.nextInt((right - left) + 1) + left;
//        int pivotIndex = left + (right - left) / 2;
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, right);

        int leftBound = left;
        int rightBound = right - 1;
        while (leftBound <= rightBound) {
            if (array[leftBound] >= pivot) {
                leftBound++;
            } else if (array[rightBound] < pivot) {
                rightBound--;
            } else {
                swap(array, leftBound++, rightBound--);
            }
        }
        swap(array, leftBound, right);
        return leftBound;
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void main(String[] args) {
        FindKthLargest_215 test = new FindKthLargest_215();
        System.out.println(test.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
        System.out.println(test.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(test.findKthLargest(new int[]{5, 2, 4, 1, 3, 6, 0}, 4));
        System.out.println(test.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 9));
    }
}
