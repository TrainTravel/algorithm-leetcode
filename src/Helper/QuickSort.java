package Helper;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 3/25/18
 * Time: 23:33
 */

public class QuickSort {
    private int[] toSort;
    private int pivot;

    public QuickSort(int[] sortArray) {
        toSort = sortArray;
    }

    public int[] sort() {

        /* Sort from large to small */
        pivot = toSort[toSort.length / 2];
        int i = 0;
        int j = toSort.length - 1;
        while (i < toSort.length - 1) {
            if (toSort[i] < toSort[j]) {
                i++;
                j--;
            }
            
        }
        return toSort;
    }
}
