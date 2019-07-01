package Solution.BitOpearation;

import java.util.Arrays;

/**
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice.
 * Find the two elements that appear only once.
 *
 * @author BorisMirage
 * Time: 2019/06/30 16:44
 * Created with IntelliJ IDEA
 */

public class SingleNumber_260 {
    /**
     * Get the XOR of the two numbers we need to find.
     *
     * @param nums given array
     * @return two elements that appear only once
     */
    public int[] singleNumber(int[] nums) {

        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }

        diff &= -diff;      // get its last set bit

        int[] result = {0, 0};        // this array stores the two numbers we will return

        for (int num : nums) {
            if ((num & diff) == 0) {        // the bit is not set
                result[0] ^= num;
            } else {        // the bit is set
                result[1] ^= num;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SingleNumber_260 test = new SingleNumber_260();
        System.out.println(Arrays.toString(test.singleNumber(new int[]{1, 1, 2, 2, 3, 3, 4, 5})));
    }
}
