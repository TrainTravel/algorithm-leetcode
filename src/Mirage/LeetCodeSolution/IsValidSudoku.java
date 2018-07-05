package Mirage.LeetCodeSolution;

import java.util.HashSet;
import java.util.Set;

/**
 * @author BorisMirage
 * Time: 2018/06/21 17:09
 * Created with IntelliJ IDEA
 */

public class IsValidSudoku {
    /**
     * Determine if a 9x9 Sudoku board is valid.
     * Only the filled cells need to be validated according to the following rules:
     * 1. Each row must contain the digits 1-9 without repetition.
     * 2. Each column must contain the digits 1-9 without repetition.
     * 3. Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
     * 4. The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
     * <p>
     * Note:
     * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
     * Only the filled cells need to be validated according to the mentioned rules.
     * The given board contain only digits 1-9 and the character '.'.
     * The given board size is always 9x9.
     *
     * @param board input 9x9 char array as board
     * @return whether this board is valid
     */
    public boolean isValidSudoku(char[][] board) {

        /* Use Set to store each int in board's position */
        Set<String> boardSet = new HashSet<>();

        /* Traverse each element in board */
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                /* Check every position in board */
                if (board[i][j] != '.') {

                    /* board record format(in String): column(char), (char)row, block(char)block */
                    String current = "(" + board[i][j] + ")";
                    if (!boardSet.add(i + current) || !boardSet.add(current + j) || !boardSet.add(i / 3 + current + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
