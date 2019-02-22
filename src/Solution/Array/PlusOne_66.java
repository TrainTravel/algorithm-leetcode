package Solution.Array;

/**
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * The digits are stored such that the most significant digit is at the head of the list.
 * Each element in the array contain a single digit.
 * Integer does not contain any leading zero, except the number 0 itself.
 *
 * @author BorisMirage
 * Time: 2018/08/06 14:09
 * Created with IntelliJ IDEA
 */

public class PlusOne_66 {
    /**
     * Be careful about carry of last digit.
     * If last digit is not 9, then directly return input array.
     * Otherwise, calculate each digit if carry is required.
     * Finally, add a new int at front of array as carry.
     *
     * @param digits input int array
     * @return array after plus one.
     */
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {

            /* If no carry is found in current position then return array with add one */
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        /* If each digit is 9 */
        int[] res = new int[n + 1];
        res[0] = 1;

        return res;
    }
}
