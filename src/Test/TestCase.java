package Test;

import LeetCodeSolution.*;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 3/26/18
 * Time: 14:40
 */

public class TestCase {
    public void testCase() {

    }

    public static void main(String[] args) {

        /* Two Sum Test */

//        TwoSum twoSumTest = new TwoSum();
//        int[] testArray = {3, 5, 6, 8, 7};
//        System.out.println(Arrays.toString(twoSumTest.twoSum(testArray, 8)));

//        /* Longest substring Test */
//        LengthOfLongestSubstring lengthOfLongestSubstringTest = new LengthOfLongestSubstring();
//        System.out.println(lengthOfLongestSubstringTest.lengthOfLongestSubstring("tmmzuxt"));

//        /* Add 2 numbers Test */
//        AddTwoNumbers addTwoNumbersTest = new AddTwoNumbers();

//        /* Find median Test */
//        int[] num1 = {1, 2, 3};
//        int[] num2 = {4, 5, 6};
//        FindMedianSortedArrays findMedianSortedArraysTest = new FindMedianSortedArrays();
//        System.out.println(findMedianSortedArraysTest.findMedianSortedArrays(num1, num2));

//        /* Reverse int Test */
//        ReverseInteger reverseIntegerTest = new ReverseInteger();
//        System.out.println(reverseIntegerTest.reverseInteger(1534236469));

//        /* Merge 2 arrays test */
//        MergeTwoSortedArray mergeTwoSortedArray = new MergeTwoSortedArray();
//        System.out.println(Arrays.toString(mergeTwoSortedArray.MergeTwoSortedArray(num1, num2)));

//        /* Longest Palindromic Substring Test*/
//        LongestPalindromicSubstring longestPalindromicSubstringTest = new LongestPalindromicSubstring();
//        System.out.println(longestPalindromicSubstringTest.longestPalindrome("s"));\

//        /* Atoi test */
//        MyAtoi myAtoiTest =  new MyAtoi();
//        System.out.println(myAtoiTest.myAtoi("   - 321"));
//        System.out.println(myAtoiTest.myAtoi("  -0012a42"));
//        System.out.println(myAtoiTest.myAtoi("   +0 123"));
//        System.out.println(myAtoiTest.myAtoi("    010"));

//        /* Zig Zag test */
//        ZigZagConversion zigZagConversionTest = new ZigZagConversion();
//        String testS = "abcdefghijk";
//        int numRow = 4;
//        System.out.println(zigZagConversionTest.convert(testS, numRow));

//        /* Palindrome Number Test*/
//        PalindromeNumber palindromeNumberTest = new PalindromeNumber();
//        System.out.println(palindromeNumberTest.isPalindrome(0000));

//        /* Max Area Test */
//        int[] height = {1, 8, 3, 6, 8, 3, 5, 3};
//        MaxArea MaxAreaTest = new MaxArea();
//        System.out.println(MaxAreaTest.MaxArea(height));

//        /* Three sum test*/
//        int[] test = {0,-4,-1,-4,-2,-3,2};
//        ThreeSum threeSumTest = new ThreeSum();
//        System.out.println(threeSumTest.threeSum(test));
//
//        /* RegularExpressionMatching Test*/
//        RegularExpressionMatching regularExpressionMatchingTest = new RegularExpressionMatching();
//        System.out.println(regularExpressionMatchingTest.isMatch("bbbba", ".*a*a"));              // true
//        System.out.println(regularExpressionMatchingTest.regularExpressionMatching("aaa", "ab*ac*a"));              // true
//        System.out.println(regularExpressionMatchingTest.regularExpressionMatching("aaa", "a*a"));                  // true
//        System.out.println(regularExpressionMatchingTest.regularExpressionMatching("mississippi", "mis*is*ip*."));  // true
//        System.out.println(regularExpressionMatchingTest.regularExpressionMatching("a", "ab*"));                    // true
//        System.out.println(regularExpressionMatchingTest.regularExpressionMatching("aab", "c*a*b"));                // true
//        System.out.println(regularExpressionMatchingTest.regularExpressionMatching("aaaa", "a*"));                    // true
//        System.out.println();
//        System.out.println(regularExpressionMatchingTest.regularExpressionMatching("baaa", ".c"));          // false
//        System.out.println(regularExpressionMatchingTest.regularExpressionMatching("aa", "a"));             // false
//        System.out.println(regularExpressionMatchingTest.regularExpressionMatching("aaaaaa", "aa"));        // false
//        System.out.println(regularExpressionMatchingTest.regularExpressionMatching("aaba", "ab*a*c*a"));    // false
//        System.out.println(regularExpressionMatchingTest.regularExpressionMatching("mississippi", "mis*is*p*."));    // false
//        System.out.println(regularExpressionMatchingTest.regularExpressionMatching("abcd", "d*"));          // false
//        System.out.println(regularExpressionMatchingTest.regularExpressionMatching("aaa", "aaaa"));         // false
//        System.out.println(regularExpressionMatchingTest.regularExpressionMatching("aaa", "aa"));           // false
//        System.out.println(regularExpressionMatchingTest.regularExpressionMatching("a", "ab*a"));           // false


//        /* RomanToInt Test */
//        RomanToInt romanIntTest = new RomanToInt();
//        System.out.println(romanIntTest.romanToInt("MCMXCIV"));

//        /* IntToRoman Test */
//        IntToRoman intToRomanTest = new IntToRoman();
//        System.out.println(intToRomanTest.intToRoman(100));

//        /* 3 Sum Closest Test*/
//        ThreeSumClosest threeSumClosestTest = new ThreeSumClosest();
////        int[] test3SumC = {1, 8, 3, 6, 8, 3, 5, 3};
//        int[] test = {-1, 2, 1, -4};
//        System.out.println(threeSumClosestTest.threeSumClosest(test, 1));

//        /* Parentheses Test */
//        IsValid isValidTest = new IsValid();
//        System.out.println(isValidTest.isValid("()[]{}"));

        /* Generate Parentheses Test */
        GenerateParenthesis generateParenthesisTest = new GenerateParenthesis();
        System.out.println(generateParenthesisTest.generateParenthesis(3));

    }
}
