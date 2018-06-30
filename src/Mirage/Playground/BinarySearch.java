package Mirage.Playground;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 2/25/18
 * Time: 14:38
 */

public class BinarySearch {

    private int[] searchArray;
    private int findNumber;


    public BinarySearch(int[] Array) {
        searchArray = Array;
    }

    /* If this array is sorted, then this method can be used. */
    public int SearchInSortedArray(int Number) {
        findNumber = Number;

        int startIndex = 0;
        int endIndex = searchArray.length - 1;

        /* If length is even, then index is odd.
         * However, it will always return middle value. */
        int middleIndex = (endIndex - startIndex) / 2;

        while (middleIndex > 0) {
            if (findNumber > searchArray[middleIndex]) {
                startIndex = middleIndex;
                middleIndex = (endIndex - startIndex) / 2;
            } else if (findNumber < searchArray[middleIndex]) {
                endIndex = middleIndex;
                middleIndex = (endIndex - startIndex) / 2;
            } else {
                return middleIndex;
            }
        }
        return -1;
    }

    /* Can be used in any array with O(n) time complexity. */
    public int[] FindMinMax() {
        /* First element is index in array.
         * Second element is the value under this element. */
        int[] resultMinMax = {0, 0, 0, 0};

        int maxInArray = searchArray[0];
        int minInArray = searchArray[0];
        int maxIndex = 0;
        int minIndex = searchArray.length - 1;

        for (int i = 0; i < searchArray.length; i++) {
            if (maxInArray < searchArray[i]) {
                maxInArray = searchArray[i];
            }
            i++;
        }
        for (int j = searchArray.length - 1; j > 0; j--) {
            if (minInArray > searchArray[j]) {
                minInArray = searchArray[j];
            }
        }
        resultMinMax[0] = maxIndex;
        resultMinMax[1] = maxInArray;
        resultMinMax[2] = minIndex;
        resultMinMax[3] = minInArray;
        return resultMinMax;
    }

    public static void main(String[] args) {
        int[] sampleArray = {1, 2, 3, 5, 15};
        int searchNumber = 3;

        /* New class initialize. */
        BinarySearch sampleClass = new BinarySearch(sampleArray);

        System.out.println(sampleClass.SearchInSortedArray(searchNumber));
        System.out.println(Arrays.toString(sampleClass.FindMinMax()));
    }
}
