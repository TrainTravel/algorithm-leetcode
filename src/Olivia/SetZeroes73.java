package Olivia;

public class SetZeroes73 {
    public void setZeroes(int[][] matrix) {
        boolean clearRow = false;
        boolean clearCol = false;
        /* check the col and col */
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        clearCol = true;
                    }
                    if (j == 0) {
                        clearRow = true;
                    } else {
                        matrix[0][j] = 0;
                        matrix[i][0] = 0;
                    }
                }
            }
        }
        /* set zeros */
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
                if (matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (clearCol) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if (clearRow) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
