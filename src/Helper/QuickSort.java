package Helper;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 3/25/18
 * Time: 23:33
 */

public class QuickSort {
    private int[] toSort;

    public QuickSort(int[] sortArray) {
        toSort = sortArray;
    }

    /**
     * Quick sort with recursively partition. Sort target array from small to large.
     *
     * @param left  left bound INDEX
     * @param right right bound INDEX
     * @return partitioned array
     */
    public int[] sort(int left, int right) {

        if (toSort.length == 1) {
            return toSort;
        }
        if (toSort.length == 2) {
            if (toSort[0] == toSort[1]) {
                return toSort;
            } else if (toSort[0] > toSort[1]) {
                switchElement(0, 1);
            }
            return toSort;
        }

        /* Select pivot and index. Switch pivot and first element in array */
        int pivotIndex = toSort[(right - left) / 2];
        switchElement(left, pivotIndex);
        int i = left;
        int j = right;

        /* Move pivot, if element next to pivot smaller than pivot, then swith them */
        while (i < j) {
            if (toSort[i] < toSort[i + 1]) {
                switchElement(i, i + 1);
                i++;
            } else {
                /* Pick element from right to left that is smaller than pivot and switch */
                while (j > i) {
                    if (toSort[j] > toSort[i + 1]) {
                        j--;
                    } else {
                        switchElement(i + 1, j);
                        break;
                    }
                }
            }
        }
        sort(left, i);
        sort(j, right);
        return toSort;
    }

    private void switchElement(int index1, int index2) {
        toSort[index1] = toSort[index1] + toSort[index2];
        toSort[index2] = toSort[index1] - toSort[index2];
        toSort[index1] = toSort[index1] - toSort[index2];
    }
}
