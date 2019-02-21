package Mirage.LeetCodeSolution;

/**
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 *
 * @author BorisMirage
 * Time: 2018/08/05 16:36
 * Created with IntelliJ IDEA
 */

public class TotalNQueens_52 {
    /**
     * Based on special property of queen, search can be done column by column (or row by row).
     *
     * @param n placing n queens
     * @return List contains all solutions that distinct board configuration of the n-queens' placement
     */
    public int totalNQueens(int n) {

        int[] res = {0};
        char[][] chessBoard = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chessBoard[i][j] = '.';
            }
        }

        backtracking(chessBoard, 0, res);
        return res[0];
    }

    /**
     * Use backtracking to traverse each possible place in chess board
     *
     * @param chessBoard char array that represent chess board
     * @param c          column number of current position
     * @param count      counter
     */
    private void backtracking(char[][] chessBoard, int c, int[] count) {
        if (c == chessBoard.length) {
            count[0] += 1;
        }
        for (int i = 0; i < chessBoard.length; i++) {
            if (isValid(chessBoard, i, c)) {
                chessBoard[i][c] = 'Q';
                backtracking(chessBoard, c + 1, count);
                chessBoard[i][c] = '.';
            }
        }

    }

    /**
     * Check if current position is valid to put queen.
     * If two queen is at same diagram, then there row num and column num will:
     * 1. r1 + c2 == r2 + c1
     * 2. r1 + c1 == r2 + c2
     * And also, two position should not be in same row and column.
     *
     * @param temp chess board
     * @param r    current row
     * @param c    current column
     * @return true if valid, false otherwise
     */
    private boolean isValid(char[][] temp, int r, int c) {
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < c; j++) {
                if (temp[i][j] == 'Q' && (r + j == c + i || r + c == i + j || i == r))
                    return false;
            }
        }
        return true;
    }
}
