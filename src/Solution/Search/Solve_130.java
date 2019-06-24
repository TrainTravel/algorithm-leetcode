package Solution.Search;

import Lib.Point;

import java.util.LinkedList;

/**
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * Surrounded regions shouldn’t be on the border, any 'O' on the border of the board are not flipped to 'X'.
 * Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
 * Two cells are connected if they are adjacent cells connected horizontally or vertically.
 *
 * @author BorisMirage
 * Time: 2019/05/01 14:28
 * Created with IntelliJ IDEA
 */

public class Solve_130 {
    /**
     * Find all 'O' on boundary of given board and relating 'O', set them to a third value.
     * Use BFS to searching relating 'O'.
     * These 'O's will not be flipped.
     * After such 'O's are all found, flip the rest 'O's.
     *
     * @param board given board
     */
    public void solve(char[][] board) {
        if (board.length < 2 || board[0].length < 2) {
            return;
        }

        /* Find all 'O' on wall of board and all relating 'O'. These 'O' will not be flipped. */
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ((i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) && board[i][j] == 'O') {
                    board[i][j] = 'T';
                    LinkedList<Point> q = new LinkedList<>();
                    q.offer(new Point(i, j));

                    while (!q.isEmpty()) {
                        Point temp = q.remove();
                        int r = temp.x;
                        int c = temp.y;

                        /* left */
                        if (r - 1 > -1 && board[r - 1][c] == 'O') {
                            board[r - 1][c] = 'T';
                            q.offer(new Point(r - 1, c));
                        }

                        /* right */
                        if (r + 1 < board.length && board[r + 1][c] == 'O') {
                            board[r + 1][c] = 'T';
                            q.offer(new Point(r + 1, c));
                        }

                        /* top */
                        if (c - 1 > -1 && board[r][c - 1] == 'O') {
                            board[r][c - 1] = 'T';
                            q.offer(new Point(r, c - 1));
                        }

                        /* bottom */
                        if (c + 1 < board[0].length && board[r][c + 1] == 'O') {
                            board[r][c + 1] = 'T';
                            q.add(new Point(r, c + 1));
                        }
                    }
                }
            }
        }

        /* Flip other 'O' to 'X' */
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
