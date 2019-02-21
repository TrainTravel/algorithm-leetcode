package Mirage.Test;


import Mirage.LeetCodeSolution.LRUCache;

/**
 * This is a test class for unit test in package LeetCodeSolution.
 *
 * @author BorisMirage
 * Time: 2018/03/26 14:40
 * Created with IntelliJ IDEA
 */

public class SolutionTest {


    public static void main(String[] args) {
        System.out.println("Test Complete. ");



//        /* Multiply */
//        Multiply multiplyTest = new Multiply();
//        String a1 = "123";
//        String a2 = "456";
//        System.out.println(multiplyTest.multiply(a1, a2));

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
//        GroupAnagrams_49 groupAnagramsTest = new GroupAnagrams_49();
//        String[] strs = {"nozzle","punjabi","waterlogged","imprison","crux","numismatists","sultans","rambles","deprecating"};
//        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
//
//        System.out.println(groupAnagramsTest.groupAnagrams(strs));

//        /* Trapping Rain Water */
//        Trap trapTest = new Trap();
//        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
//        System.out.println(trapTest.trap(height));


//        /* Maximum Subarray */
//        MaxSubArray maxSubArrayTest = new MaxSubArray();
//        int[] m = {1,1,1,1,1};
//        System.out.println(maxSubArrayTest.maxSubArray(m));

//        /* Jump Game */
//        CanJump_55 canJumpTest = new CanJump_55();
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
//        GetPermutation_60 getPermutationTest = new GetPermutation_60();
//        System.out.println(getPermutationTest.getPermutation(4, 9));

//        /* Minimum Path Sum */
//        MinPathSum minPathSumTest = new MinPathSum();
//        int[][] grid = {{1, 2}, {5, 6}, {1, 1}};
//        System.out.println(minPathSumTest.minPathSum(grid));

//        /* Climbing Stairs */
//        ClimbStairs_70 climbStairsTest = new ClimbStairs_70();
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
//        Combine_77 combineTest = new Combine_77();
//        System.out.println(combineTest.combine(4, 3));

//        /* Subsets */
//        SubsetsWithDup subsetsWithDupTest = new SubsetsWithDup();
//        int[] sbs = {1, 2, 3};
//        System.out.println(subsetsWithDupTest.subsetsWithDup(sbs));

//        /* Word Search */
//        Exist_79 existTest = new Exist_79();
//        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        char[][] board = {{'A'}};
//        System.out.println(existTest.exist(board, "ABCZZ"));

//        /* Remove Duplicates from Sorted Array II */
//        RemoveDuplicatesII removeDuplicatesIITest = new RemoveDuplicatesII();
//        int[] dup = {1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4};
////        int[] dup = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
////        int[] dup = {1};
//        System.out.println(removeDuplicatesIITest.removeDuplicatesII(dup));

//        /* Search in Rotated Sorted Array II */
//        SearchII searchIITest = new SearchII();
//        int[] ss = {1, 1, 3, 1};
//        System.out.println(searchIITest.searchII(ss, 3));

    }
}
