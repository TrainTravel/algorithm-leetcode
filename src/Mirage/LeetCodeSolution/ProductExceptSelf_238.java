package Mirage.LeetCodeSolution;

/**
 * Given an array nums of n integers where n > 1.
 * Return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 *
 * @author BorisMirage
 * Time: 2019/02/20 19:18
 * Created with IntelliJ IDEA
 */

public class ProductExceptSelf_238 {
    public int[] productExceptSelf(int[] nums) {

        /* Special case */
        if (nums.length < 1) {
            return nums;
        }

        int p = 1;
        int[] res = new int[nums.length];
        int countZero = 0;


        for (int num : nums) {
            if (num != 0) {
                p = p * num;
            } else {
                countZero += 1;
            }
        }

        if (countZero == 0) {
            for (int i = 0; i < nums.length; i++) {
                res[i] = p / nums[i];
            }
        } else if (countZero == 1) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    res[i] = p;
                }
            }
        }

        return res;
    }
}
