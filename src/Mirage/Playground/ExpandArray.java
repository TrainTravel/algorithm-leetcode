package Mirage.Playground;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 2/26/18
 * Time: 15:16
 *
 * This class is based on array object, which contains some basic method of an array.
 * And it has some expanded function, such as quick sort, append a new element.
 */


public class ExpandArray {

    /**
     * Local variable here.
     *
     * @param expandArray: basic array that contains the origin array and will be modified.
     * */
    private int[] expandArray;

    /* Initialize the class */
    ExpandArray(int[] array) {
        expandArray = array;
    }

    public int selectValue(int index) {
        return expandArray[index];
    }

    public int[] showArray() {
        return expandArray;
    }

    /**
     * This can be improved when quick sort is completed.
     * */
    public boolean isExist(int num) {
        for (int i = 0; i < expandArray.length; i++) {
            if (num == expandArray[i])
                return true;
        }
        return false;
    }

    public void sort(int[] array, int start, int end) {
        int pivot = array.length / 2;

        if (end - start < 0 || array.length == 1) {
            System.out.println(Arrays.toString(array));
        } else {

            /* Switch pivot to the last */
            switchPosition(array, pivot, array.length - 1);

            /* Search from left to right */
            while (start <= end) {
                while (array[start] < pivot) {
                    start++;
                }
                while (array[end] > pivot) {
                    end--;
                }
                if (start < end) {
                    array = switchPosition(array, start, end);
                    start++;
                    end--;
                } else if (start == end) {
                    start++;
                }
            }
        }
        sort(array, start, pivot);
        sort(array, pivot, end);
    }

    public int[] switchPosition(int[] array, int index1, int index2) {
        array[index1] = array[index2] + array[index1];
        array[index2] = array[index1] - array[index2];
        array[index1] = array[index1] - array[index2];
        return array;
    }

//    public static void main(String[] args) {
//        int[] sampleArray = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
//        ExpandArray sample = new ExpandArray();
//    }
}
