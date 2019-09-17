package Solution.Array;

/**
 * Given an array arr that is a permutation of [0, 1, ..., arr.length - 1].
 * Split the array into some number of "chunks" (partitions), and individually sort each chunk.
 * After concatenating them, the result equals the sorted array.
 * What is the most number of chunks we could have made?
 *
 * @author BorisMirage
 * Time: 2019/09/17 11:06
 * Created with IntelliJ IDEA
 */

public class MaxChunksToSorted_769 {
    /**
     * The basic idea is to use max[] array to keep track of the max value until the current position.
     * Compare it to the sorted array (indexes from 0 to arr.length - 1).
     * If the max[i] equals the element at index i in the sorted array, then the final count + 1.
     * Then, the numbers range from 0 to arr.length - 1.
     * So there is no need to sort the arr, simply use the index for comparison, which will finally be O(n).
     *
     * @param arr given array
     * @return most number of chunks could have made
     */
    public int maxChunksToSorted(int[] arr) {

        /* Corner case */
        if (arr.length == 0) {
            return 0;
        }

        int max = 0, count = 0;

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
            if (max == i) {
                count++;
            }
        }

        return count;
    }
}
