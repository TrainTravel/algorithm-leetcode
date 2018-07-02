package Olivia;

import java.util.HashSet;

public class IsValidSudoku36 {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> col = new HashSet<>();
            HashSet<Character> box = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (row.contains(board[i][j])) {
                        return false;
                    }
                    row.add(board[i][j]);
                }
                if (board[j][i] != '.') {
                    if (col.contains(board[j][i])) {
                        return false;
                    }
                    col.add(board[j][i]);
                }
                int box_row = 3 * (i / 3) + j / 3;
                int box_col = 3 * (i % 3) + j % 3;
                if (board[box_row][box_col] != '.') {
                    if (box.contains(board[box_row][box_col])) {
                        return false;
                    } else {
                        box.add(board[box_row][box_col]);
                    }
                }
            }

        }
        return true;
    }
}
