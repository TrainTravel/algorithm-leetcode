package Solution.Bucket;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 *
 * @author BorisMirage
 * Time: 2019/07/06 15:56
 * Created with IntelliJ IDEA
 */

public class LargestNumber_179 {
    /**
     * The principle of comparison is similar to dictionary lexical order.
     * Only compare first number between two numbers, place larger one at head of result for a largest number.
     * If two numbers have same first digit, then compare second digit with same rule.
     *
     * @param nums given array
     * @return largest # that this array could make up
     */
    public String largestNumber(int[] nums) {

        /* Corner case */
        if (nums == null || nums.length == 0) {
            return "";
        }

        String[] num = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            num[i] = String.valueOf(nums[i]);       // convert int to string for comparator
        }

        /* The principle of comparison is similar to dictionary lexical order.
         * Only compare first number between two numbers, place larger one at head of result for a largest number.
         * If two numbers have same first digit, then compare second digit with same rule. */
        Comparator<String> comparator = (str1, str2) -> {
            String s1 = str1 + str2;
            String s2 = str2 + str1;
            return s2.compareTo(s1);
        };

        Arrays.sort(num, comparator);

        if (num[0].charAt(0) == '0') {      // if whole array is 0
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String s : num) {
            sb.append(s);
        }

        return sb.toString();
    }
}
