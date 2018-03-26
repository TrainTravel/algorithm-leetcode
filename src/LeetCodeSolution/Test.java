package LeetCodeSolution;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 3/25/18
 * Time: 23:28
 */

public class Test {
    public static void main(String[] args) {

        /* Two Sum test */
        TwoSum twoSumTest = new TwoSum();
        int[] testArray = {3, 5, 6, 8, 7};
        int num = 8;
        System.out.println(Arrays.toString(twoSumTest.twoSum(testArray, num)));

        /* Longest substring test */
        LengthOfLongestSubstring lengthOfLongestSubstringTest = new LengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstringTest.lengthOfLongestSubstring("tmmzuxt"));

        /* Add 2 numbers test */
        AddTwoNumbers addTwoNumbersTest = new AddTwoNumbers();
        
    }
}
