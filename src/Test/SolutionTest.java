package Test;


/**
 * This is a test class for unit test in package Solution.
 *
 * @author BorisMirage
 * Time: 2018/03/26 14:40
 * Created with IntelliJ IDEA
 */

public class SolutionTest {


    public static void main(String[] args) {
        System.out.println("Test Complete. ");



//        /* Multiply */
//        MultiplyString_43 multiplyTest = new MultiplyString_43();
//        String a1 = "123";
//        String a2 = "456";
//        System.out.println(multiplyTest.multiply(a1, a2));

//        /* Permutations */
//        Permute_46 permuteTest = new Permute_46();
//        int[] c = {1};
//        System.out.println(permuteTest.permute(c));

//        /* Permutations II */
//        PermuteUnique_47 permuteUniqueTest = new PermuteUnique_47();
//        int[] c = {1, 2, 2, 3};
//        System.out.println(permuteUniqueTest.permuteUnique(c));

//        /* Rotation */
//        Rotate_48 rotateTest = new Rotate_48();
//        int[][] r = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        rotateTest.rotate(r);
//        System.out.println(Arrays.deepToString(r));

//        /* Valid Anagram */
//        IsAnagram_242 isAnagramTest = new IsAnagram_242();
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
//        Trap_42 trapTest = new Trap_42();
//        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
//        System.out.println(trapTest.trap(height));


//        /* Maximum Subarray */
//        MaxSubArray_53 maxSubArrayTest = new MaxSubArray_53();
//        int[] m = {1,1,1,1,1};
//        System.out.println(maxSubArrayTest.maxSubArray(m));

//        /* Jump_45 Game */
//        CanJump_55 canJumpTest = new CanJump_55();
//        int[] jump = {3, 1, 1, 0, 1, 0};
//        System.out.println(canJumpTest.canJump(jump));
//
//        /* Length of Last Word */
//        LengthOfLastWord_58 lengthOfLastWordTest = new LengthOfLastWord_58();
//        String s = "aa bb";
//        System.out.println(lengthOfLastWordTest.lengthOfLastWord(s));

//        /* Missing Number */
//        MissingNumber_268 missingNumberTest = new MissingNumber_268();
//        int[] jump = {2, 3, 1, 0, 5};
//        System.out.println(missingNumberTest.missingNumberWithBitManipulate(jump));

//        /* Longest Valid Parentheses */
//        LongestValidParentheses_32 longestValidParenthesesTest = new LongestValidParentheses_32();
//        System.out.println(longestValidParenthesesTest.longestValidParenthesesDP(")()())"));

//        /* Unique Paths II */
//        UniquePathsWithObstacles_63 uniquePathsWithObstaclesTest = new UniquePathsWithObstacles_63();
//        int[][] rrrrrrr = {{0, 0}, {1, 1}, {0, 0}};
//        System.out.println(uniquePathsWithObstaclesTest.uniquePathsWithObstacles(rrrrrrr));

//        /* N Queens */
//        SolveNQueens_51 solveNQueensTest = new SolveNQueens_51();
//        System.out.println(solveNQueensTest.solveNQueens(5));

//        /* N-Queens II */
//        TotalNQueens_52 totalNQueensTest = new TotalNQueens_52();
//        System.out.println(totalNQueensTest.totalNQueens(5));

//        /* Plus One */
//        PlusOne_66 plusOneTest = new PlusOne_66();
//        int[] tt = {4,3,2,1};
//        System.out.println(Arrays.toString(plusOneTest.plusOne(tt)));

//        /* Permutation Sequence */
//        int[] ttt = {1, 2, 3};
//        GetPermutation_60 getPermutationTest = new GetPermutation_60();
//        System.out.println(getPermutationTest.getPermutation(4, 9));

//        /* Minimum Path Sum */
//        MinPathSum_64 minPathSumTest = new MinPathSum_64();
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
//        SetZeroes_73 setZeroesTest = new SetZeroes_73();
//        setZeroesTest.setZeroes(zeros);

//        /* Search_33 a 2D Matrix */
//        SearchMatrix_74 searchMatrixTest = new SearchMatrix_74();
//        int[][] mmmmmm = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
//        int[][] mmmmmm = {{1}};
//        int[][] mmmmmm = {};
//        System.out.println(searchMatrixTest.searchMatrix(mmmmmm, 1));

//        /* Sort Colors */
//        SortColors_75 sortColorsTest = new SortColors_75();
//        int[] sss = {1, 1, 2, 0, 1, 1, 1, 2};
//        sortColorsTest.sortColors(sss);
//        System.out.println(Arrays.toString(sss));

//        /* Combinations */
//        Combine_77 combineTest = new Combine_77();
//        System.out.println(combineTest.combine(4, 3));

//        /* Subsets */
//        SubsetsWithDup_90 subsetsWithDupTest = new SubsetsWithDup_90();
//        int[] sbs = {1, 2, 3};
//        System.out.println(subsetsWithDupTest.subsetsWithDup(sbs));

//        /* Word Search_33 */
//        Exist_79 existTest = new Exist_79();
//        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        char[][] board = {{'A'}};
//        System.out.println(existTest.exist(board, "ABCZZ"));

//        /* Remove Duplicates from Sorted Array II */
//        RemoveDuplicatesII_80 removeDuplicatesIITest = new RemoveDuplicatesII_80();
//        int[] dup = {1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4};
////        int[] dup = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
////        int[] dup = {1};
//        System.out.println(removeDuplicatesIITest.removeDuplicatesII(dup));

//        /* Search_33 in Rotated Sorted Array II */
//        SearchII_81 searchIITest = new SearchII_81();
//        int[] ss = {1, 1, 3, 1};
//        System.out.println(searchIITest.searchII(ss, 3));

    }
}
