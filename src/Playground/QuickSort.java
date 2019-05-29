package Playground;

/**
 * Quick sort implementation.
 *
 * @author BorisMirage
 * Time: 2018/03/25 23:33
 * Created with IntelliJ IDEA
 */

public class QuickSort {
    private int[] arr;

    /**
     * Put array into class and check length.
     *
     * @param sortArray array to be sort
     */
    public int[] QuickSort(int[] sortArray) {

        /* Corner case */
        if (sortArray.length == 0 || sortArray.length == 1) {
            return sortArray;
        }
        arr = sortArray;
        partition(0, arr.length - 1);
        return arr;
    }

    /**
     * Quick sort with recursively partition.
     * Sort target array from small to large.
     *
     * @param leftIndex  left bound INDEX
     * @param rightIndex right bound INDEX
     */
    public void partition(int leftIndex, int rightIndex) {

        /* Corner case and end point for recursion */
        if (leftIndex == rightIndex || arr == null) {
            return;
        }
        if (leftIndex == rightIndex - 1) {
            if (leftIndex > rightIndex) {
                int temp = arr[leftIndex];
                arr[leftIndex] = arr[rightIndex];
                arr[rightIndex] = temp;
            }
            return;
        }

        int l = leftIndex;
        int r = rightIndex;

        /* Select pivot */
        int pivot = arr[l + (r - l) / 2];

        /* Partition: move elements smaller than pivot to pivot's left, rest to pivot's right */
        while (l < r) {

            /* Pass elements that smaller*/
            while (arr[l] < pivot) {
                l++;
            }
            while (arr[r] > pivot) {
                r--;
            }

            /* Switch elements */
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }

        /* Recursion: repeat this process into sub array until reach end point */
        partition(leftIndex, r);
        partition(l, rightIndex);
    }
}
