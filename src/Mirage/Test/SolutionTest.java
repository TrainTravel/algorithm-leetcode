package Mirage.Test;


import Mirage.LeetCodeSolution.RemoveDuplicatesII;

/**
 * This is a test class for unit test in package LeetCodeSolution.
 *
 * @author BorisMirage
 * Time: 2018/03/26 14:40
 * Created with IntelliJ IDEA
 */

public class SolutionTest {


    public static void main(String[] args) {

//        /* Two Sum Test */
//        TwoSum twoSumTest = new TwoSum();
//        int[] testArray = {3, 5, 6, 8, 7};
//        System.out.println(Arrays.toString(twoSumTest.twoSum(testArray, 8)));
//
//        /* Longest substring Test */
//        LengthOfLongestSubstring lengthOfLongestSubstringTest = new LengthOfLongestSubstring();
//        System.out.println(lengthOfLongestSubstringTest.lengthOfLongestSubstring("tmmzuxt"));
//        System.out.println(lengthOfLongestSubstringTest.lengthOfLongestSubstring("a"));

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
//        int[] test3SumC = {1, 8, 3, 6, 8, 3, 5, 3};
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
//        int[] c = {1, 2, 2, 3};
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
//        String[] strs = {"nozzle","punjabi","waterlogged","imprison","crux","numismatists","sultans","rambles","deprecating"};
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

//        /* Jump Game */
//        CanJump canJumpTest = new CanJump();
//        int[] jump = {3, 1, 1, 0, 1, 0};
//        System.out.println(canJumpTest.canJump(jump));
//
//        /* Length of Last Word */
//        LengthOfLastWord lengthOfLastWordTest = new LengthOfLastWord();
//        String s = "aa bb";
//        System.out.println(lengthOfLastWordTest.lengthOfLastWord(s));

//        /* Missing Number */
//        MissingNumber missingNumberTest = new MissingNumber();
//        int[] jump = {2, 3, 1, 0, 5};
//        System.out.println(missingNumberTest.missingNumberWithBitManipulate(jump));

//        /* Longest Valid Parentheses */
//        LongestValidParentheses longestValidParenthesesTest = new LongestValidParentheses();
//        System.out.println(longestValidParenthesesTest.longestValidParenthesesDP(")()())"));

//        /* Unique Paths II */
//        UniquePathsWithObstacles uniquePathsWithObstaclesTest = new UniquePathsWithObstacles();
//        int[][] rrrrrrr = {{0, 0}, {1, 1}, {0, 0}};
//        System.out.println(uniquePathsWithObstaclesTest.uniquePathsWithObstacles(rrrrrrr));

//        /* N Queens */
//        SolveNQueens solveNQueensTest = new SolveNQueens();
//        System.out.println(solveNQueensTest.solveNQueens(5));

//        /* N-Queens II */
//        TotalNQueens totalNQueensTest = new TotalNQueens();
//        System.out.println(totalNQueensTest.totalNQueens(5));

//        /* Plus One */
//        PlusOne plusOneTest = new PlusOne();
//        int[] tt = {4,3,2,1};
//        System.out.println(Arrays.toString(plusOneTest.plusOne(tt)));

//        /* Permutation Sequence */
//        int[] ttt = {1, 2, 3};
//        GetPermutation getPermutationTest = new GetPermutation();
//        System.out.println(getPermutationTest.getPermutation(4, 9));

//        /* Minimum Path Sum */
//        MinPathSum minPathSumTest = new MinPathSum();
//        int[][] grid = {{1, 2}, {5, 6}, {1, 1}};
//        System.out.println(minPathSumTest.minPathSum(grid));

//        /* Climbing Stairs */
//        ClimbStairs climbStairsTest = new ClimbStairs();
//        System.out.println(climbStairsTest.climbStairs(5));

//        /* Set Matrix Zeroes */
////        int[][] zeros = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
////        int[][] zeros = {{0}};
//        int[][] zeros = {{1, 0, 3}};
//
//        SetZeroes setZeroesTest = new SetZeroes();
//        setZeroesTest.setZeroes(zeros);

//        /* Search a 2D Matrix */
//        SearchMatrix searchMatrixTest = new SearchMatrix();
//        int[][] mmmmmm = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
//        int[][] mmmmmm = {{1}};
//        int[][] mmmmmm = {};
//        System.out.println(searchMatrixTest.searchMatrix(mmmmmm, 1));

//        /* Sort Colors */
//        SortColors sortColorsTest = new SortColors();
//        int[] sss = {1, 1, 2, 0, 1, 1, 1, 2};
//        sortColorsTest.sortColors(sss);
//        System.out.println(Arrays.toString(sss));

//        /* Combinations */
//        Combine combineTest = new Combine();
//        System.out.println(combineTest.combine(4, 3));

//        /* Subsets */
//        SubsetsWithDup subsetsWithDupTest = new SubsetsWithDup();
//        int[] sbs = {1, 2, 3};
//        System.out.println(subsetsWithDupTest.subsetsWithDup(sbs));

//        /* Word Search */
//        Exist existTest = new Exist();
//        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        char[][] board = {{'A'}};
//        System.out.println(existTest.exist(board, "ABCZZ"));

        /* Remove Duplicates from Sorted Array II */
        RemoveDuplicatesII removeDuplicatesIITest = new RemoveDuplicatesII();
        int[] dup = {1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4};
//        int[] dup = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
//        int[] dup = {1};
        System.out.println(removeDuplicatesIITest.removeDuplicatesII(dup));

    }
}
