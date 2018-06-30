package Mirage.Test;


import Mirage.LeetCodeSolution.*;

import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 3/26/18
 * Time: 14:40
 */

public class SolutionTest {


    public static void main(String[] args) {

//        /* Two Sum Test */
//        TwoSum twoSumTest = new TwoSum();
//        int[] testArray = {3, 5, 6, 8, 7};
//        System.out.println(Arrays.toString(twoSumTest.twoSum(testArray, 8)));

//        /* Longest substring Test */
//        LengthOfLongestSubstring lengthOfLongestSubstringTest = new LengthOfLongestSubstring();
//        System.out.println(lengthOfLongestSubstringTest.LengthOfLongestSubstring.java("tmmzuxt"));

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

//        /* Generate Parentheses Test */
//        GenerateParenthesis generateParenthesisTest = new GenerateParenthesis();
//        System.out.println(generateParenthesisTest.generateParenthesis(3));

//        /* RemoveDuplicates Test */
//        RemoveDuplicates removeDuplicatesTest = new RemoveDuplicates();
//        int[] test = {1,2,3,4};
//        System.out.println(removeDuplicatesTest.removeDuplicates(test));

//        /* StrStr Test*/
//        StrStr strStrTest = new StrStr();
//        System.out.println(strStrTest.strStr("mississippi", "issip"));

        /* Next Permutation */
//        NextPermutation nextPermutationTest = new NextPermutation();
//        int[] a = {1,3,2};
//        nextPermutationTest.nextPermutation(a);
//        System.out.println(Arrays.toString(a));

        /* Search */
//        Search searchTest = new Search();
//        int[] nums = {1, 2, 3, 4, 5, 6};
//        System.out.println(searchTest.search(nums, 4));

//        /* Search Range */
//
//        SearchRange searchRangeTest = new SearchRange();
//        int[] nums = {0, 1, 2, 3, 4, 5, 6, 6, 6, 6, 6, 8, 9, 12, 30};
//        System.out.println(Arrays.toString(searchRangeTest.searchRange(nums, 4)));

//        /* Substring with Concatenation of All Words */
//        String s = "barfoothefoobarman";
//        String[] words = {"bar", "foo"};
//
//        final long startTime = System.currentTimeMillis();  // Timer
//
//        FindSubstring findSubstringTest = new FindSubstring();
//        System.out.println(findSubstringTest.findSubstring(s, words));
//
//        final long endTime = System.currentTimeMillis();    // Timer
//        System.out.println("Time: " + (endTime - startTime) + "ms");
//
//        /* Search Insert Position */
//        SearchInsert searchInsertTest = new SearchInsert();
//        int[] nums = {1,3};
//
//        System.out.println(searchInsertTest.searchInsert(nums, 2));

//        /* Valid Sudoku */
//        IsValidSudoku isValidSudoku = new IsValidSudoku();
//        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
//                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//                {'8', '.', '.', '.', '.', '.', '.', '.', '.'},
//                {'4', '.', '.', '.', '.', '.', '.', '.', '.'},
//                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
//                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
//                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
//                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}};
//        System.out.println(isValidSudoku.isValidSudoku(board));

//        /* Solve Sudoku */
//        SolveSudoku solveSudokuTest = new SolveSudoku();
//        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
//                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//                {'8', '.', '.', '.', '.', '.', '.', '.', '.'},
//                {'4', '.', '.', '.', '.', '.', '.', '.', '.'},
//                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
//                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
//                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
//                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}};
//        solveSudokuTest.solveSudoku(board);
//        System.out.println(Arrays.deepToString(board));

//        /* Count and Say */
//        CountAndSay countAndSayTest = new CountAndSay();
//        System.out.println(countAndSayTest.countAndSay(6));

//        /* Combination Sum */
//        int[] candidate = {2, 3, 6, 7};
//        CombinationSum combinationSumTest = new CombinationSum();
//        System.out.println(combinationSumTest.combinationSum(candidate, 7));
//        candidate = new int[]{2, 3, 5};
//        System.out.println(combinationSumTest.combinationSum(candidate, 8));

//        /* Combination Sum 2 */
//        CombinationSum2 combinationSum2Test = new CombinationSum2();
//        int[] candidate = {10, 1, 2, 7, 6, 1, 5};
//        System.out.println(combinationSum2Test.combinationSum2(candidate, 8));
//        candidate = new int[]{2, 5, 2, 1, 2};
//        System.out.println(combinationSum2Test.combinationSum2(candidate, 10));
//        candidate = new int[]{2, 5, 2, 1, 2};
//        System.out.println(combinationSum2Test.combinationSum2(candidate, 5));

//        /* First Missing Positive */
//        FirstMissingPositive firstMissingPositiveTest = new FirstMissingPositive();
//
//        int[] c = {2, 3, 6, 7};
//        System.out.println(firstMissingPositiveTest.firstMissingPositive(c));       // 1
//        c = new int[]{3, 4, -1, 1};
//        System.out.println(firstMissingPositiveTest.firstMissingPositive(c));       // 2
//        c = new int[]{7, 8, 9, 11, 12};
//        System.out.println(firstMissingPositiveTest.firstMissingPositive(c));       // 1
//        c = new int[]{1, 2, 0};
//        System.out.println(firstMissingPositiveTest.firstMissingPositive(c));       // 3
//        c = new int[]{2, 5, 2, 1, 2, 3};
//        System.out.println(firstMissingPositiveTest.firstMissingPositive(c));       // 4
//        c = new int[]{3, 4, 0, 1};
//        System.out.println(firstMissingPositiveTest.firstMissingPositive(c));       // 2
//        c = new int[]{1, 2, 3, 4, 5, 6, 7};
//        System.out.println(firstMissingPositiveTest.firstMissingPositive(c));       // 8
//        c = new int[]{7, 10, 12, 11, 9, 6, 5, 1, 2, 3};
//        System.out.println(firstMissingPositiveTest.firstMissingPositive(c));       // 4

//        /* Multiply */
//        Multiply multiplyTest = new Multiply();
//        String a1 = "123";
//        String a2 = "456";
//        System.out.println(multiplyTest.multiply(a1, a2));
//
//        /* Permutations */
//        Permute permuteTest = new Permute();
//        int[] c = {1};
//        System.out.println(permuteTest.permute(c));

//        /* Permutations II */
//        PermuteUnique permuteUniqueTest = new PermuteUnique();
//        int[] c = {1};
//        System.out.println(permuteUniqueTest.permuteUnique(c));

//        /* Rotation */
//        Rotate rotateTest = new Rotate();
//        int[][] r = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        rotateTest.rotate(r);
//        System.out.println(Arrays.deepToString(r));

//        /* Valid Anagram */
//        IsAnagram isAnagramTest = new IsAnagram();
//        String s = "anagram";
//        String t = "nagaram";
//        System.out.println(isAnagramTest.isAnagram_1(s, t));

//        /* Group Anagram */
//        GroupAnagrams groupAnagramsTest = new GroupAnagrams();
////        String[] strs = {"nozzle","punjabi","waterlogged","imprison","crux","numismatists","sultans","rambles","deprecating"};
//        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
//
//        System.out.println(groupAnagramsTest.groupAnagrams(strs));

//        /* Trapping Rain Water */
//        Trap trapTest = new Trap();
//        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
//        System.out.println(trapTest.trap(height));

//        /* Jump Game II */
//        Jump jumpTest = new Jump();
//        int[] jump = {2, 3, 1, 1, 1};
//        System.out.println("Min step: " + jumpTest.jump(jump));
//        jump = new int[]{1, 3, 2};
//        System.out.println("Min step: " + jumpTest.jump(jump));
//        jump = new int[]{1, 1, 1, 1};
//        System.out.println("Min step: " + jumpTest.jump(jump));
//        jump = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 0};
//        System.out.println("Min step: " + jumpTest.jump(jump));
//        jump = new int[]{4, 1, 1, 3, 1, 1, 1};
//        System.out.println("Min step: " + jumpTest.jump(jump));

//        /* Maximum Subarray */
//        MaxSubArray maxSubArrayTest = new MaxSubArray();
//        int[] m = {1,1,1,1,1};
//        System.out.println(maxSubArrayTest.maxSubArray(m));

        /* Jump Game */
        CanJump canJumpTest = new CanJump();
        int[] jump = {3, 1, 1, 0, 1, 0};
        System.out.println(canJumpTest.canJump(jump));
    }
}
