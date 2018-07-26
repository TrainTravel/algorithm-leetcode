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

        /* New chess board */
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder tempStr = new StringBuilder();
            for (int j = 0; j < n; j++) {
                tempStr.append('.');
            }
            temp.add(tempStr.toString());
        }

        /* Special Case */
        if (n == 0) {
            res.add(temp);
            return res;
        }

        backtracking(res, temp, 0, n);
        return res;
    }

    /**
     * Use backtracking to traversal each position.
     * If the chess board has already placed n queens, return.
     *
     * @param res     result LinkedList
     * @param cache   temp List
     * @param current currently placed queen
     * @param n       n queens need to be placed.
     */
    private void backtracking(List<List<String>> res, List<String> cache, int current, int n) {
        if (current == n) {
            res.add(cache);
        } else if (current < n) {
            backtracking(res, cache, current, n);
        }
    }
}
