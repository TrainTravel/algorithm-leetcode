package Helper;

import java.util.Arrays;


/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 6/15/18
 * Time: 21:25
 */

public class Test {
    public static void main(String[] args) {
        QuickSort quickSortTest = new QuickSort();
        int[] test = {0, 0, 0, 0, 1};
        int[] x = {9, 2, 4, 7, 3, 7, 10};
        int[] x1 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] x2 = {0, 0, 0, 0,0, 0, 0, 0};
        int[] x3 = {23, 6, 1, 9, 5, 3, 64, 3, 45, 6, 7, 8};
        int[] x4 = {1};
        int[] x5 = {};

        System.out.println(Arrays.toString(test));
        System.out.println(Arrays.toString(quickSortTest.QuickSort(test)));
        System.out.println();
        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(quickSortTest.QuickSort(x)));
        System.out.println();
        System.out.println(Arrays.toString(x1));
        System.out.println(Arrays.toString(quickSortTest.QuickSort(x1)));
        System.out.println();
        System.out.println(Arrays.toString(x2));
        System.out.println(Arrays.toString(quickSortTest.QuickSort(x2)));
        System.out.println();
        System.out.println(Arrays.toString(x3));
        System.out.println(Arrays.toString(quickSortTest.QuickSort(x3)));
        System.out.println();
        System.out.println(Arrays.toString(x4));
        System.out.println(Arrays.toString(quickSortTest.QuickSort(x4)));
        System.out.println();
        System.out.println(Arrays.toString(x5));
        System.out.println(Arrays.toString(quickSortTest.QuickSort(x5)));
    }
}
