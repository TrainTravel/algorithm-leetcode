package Olivia;

/**
 * @author Time: 2018/07/16 10:50
 * Created with IntelliJ IDEA
 */

public class QuickSort {

    /**
     * Put array into class and check length.
     *
     * @param sortArray array to be sort
     */
    public int[] QuickSort(int[] sortArray) {
        int[] result = sortArray;
        if (sortArray.length == 0 || sortArray.length == 1) {
            return sortArray;
        }
        partition(result, 0, sortArray.length - 1);
        return result;
    }

    private void partition(int[] result, int startLoc, int endLoc) {
        if (startLoc == endLoc)
            return;
        if (startLoc == endLoc - 1) {
            if (result[startLoc] > result[endLoc]) {
                int tmp = result[startLoc];
                result[startLoc] = result[endLoc];
                result[endLoc] = tmp;
            }
            return;
        }
        int left = startLoc;
        int right = endLoc;
        int chosen = result[left];
        while (left < right) {
            while (result[left] < chosen) {
                left++;
            }
            while (result[right] > chosen) {
                right--;
            }
            int tmp = result[left];
            result[left] = result[right];
            result[right] = tmp;
            left++;
            right--;
        }
        partition(result, startLoc, right);
        partition(result, left, endLoc);
    }

}
