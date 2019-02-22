package Solution.Array;

/**
 * Given an array nums of n integers where n > 1.
 * Return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * Note that in this problem, the product of all elements will not exceed the max integer value.
 *
 * @author BorisMirage
 * Time: 2019/02/20 19:18
 * Created with IntelliJ IDEA
 */

public class ProductExceptSelf_238 {
    /**
     * Count the entire product of array and divide each element in next round.
     *
     * @param nums int array
     * @return array that each element equal to the product of all the elements of nums except nums[i]
     */
    public int[] productExceptSelf(int[] nums) {

        /* Special case */
        if (nums.length < 1) {
            return nums;
        }

        int p = 1;
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
                int temp = p / nums[i];
                nums[i] = temp;
            }
        } else if (countZero == 1) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    nums[i] = p;
                } else {
                    nums[i] = 0;
                }
            }
        } else {
            return new int[nums.length];
        }

        return nums;
    }
}
