package Mirage.LeetCodeSolution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement.
 * 'Q' and '.' both indicate a queen and an empty space respectively.
 * <p>
 * Example:
 * Input: 4
 * Output: [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 *
 * @author BorisMirage
 * Time: 2018/07/10 22:26
 * Created with IntelliJ IDEA
 */

public class SolveNQueens {
    /**
     * Use backtracking to solve n queens puzzle.
     * Exit recursion if there exist more than n queens.
     *
     * @param n placing n queens
     * @return List contains all solutions that distinct board configuration of the n-queens' placement
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[][] chessboard = new int[n][n];
        backtracking(res, new ArrayList<>(), chessboard);
        return res;
    }

    public void backtracking(List<List<String>> res, List<String> cache, int[][] chessboard) {


    }
}
