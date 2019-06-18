package Solution.TwoPointers;

/**
 * Given an array of integers that is already sorted in ascending order.
 * Find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers, where index1 must be less than index2.
 * Index starts from 1.
 *
 * @author BorisMirage
 * Time: 2019/02/18 13:16
 * Created with IntelliJ IDEA
 */

public class TwoSum_167 {

    /**
     * Two pointers, one starts from beginning and one starts at end.
     *
     * @param numbers int array
     * @param target  target number
     * @return index array, or null if no matches
     */
    public int[] twoSum(int[] numbers, int target) {

        int[] res = new int[2];

        int s = 0;
        int e = numbers.length - 1;

        while (s < e) {
            if (numbers[s] + numbers[e] == target) {
                res[0] = s + 1;
                res[1] = e + 1;
                return res;
            }
            if (numbers[s] + numbers[e] < target) {
                s += 1;
            } else if (numbers[s] + numbers[e] > target) {
                e -= 1;
            }
        }
        return null;
    }
}
