package Olivia;

import java.util.ArrayList;
import java.util.List;

public class TotalNQueens52 {
    int count = 0;

    public int totalNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] cur = new char[n][n];
        nQueensHelper(n, cur, 0);
        return count;
    }

    /* helper function
     *  using recursive to fill queen */
    private void nQueensHelper(int n, char[][] cur, int quantity) {
        if (quantity == n) {
            count++;
        }
        for (int i = 0; i < n; i++) {
            /* to check this place is validate or not */
            if (validate(cur, i, quantity)) {
                cur[i][quantity] = 'Q';
                nQueensHelper(n, cur, quantity + 1);
                //back to original
                cur[i][quantity] = '.';
            }
        }
    }

    /* validation function
     *  to validate whether this char[][] is validate or not
     *  return boolean */
    private boolean validate(char[][] cur, int x, int quantity) {
        for (int i = 0; i < cur.length; i++) {
            for (int j = 0; j < quantity; j++) {
                //check up and diagonal
                if (cur[i][j] == 'Q' && (x == i || Math.abs(x - i) == Math.abs(quantity - j))) {
                    return false;
                }
            }
        }
        return true;
    }

}
