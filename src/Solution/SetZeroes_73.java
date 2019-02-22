package Solution;

import java.util.Arrays;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0.
 * Solve this problem in-place.
 *
 * @author BorisMirage
 * Time: 2018/08/07 15:55
 * Created with IntelliJ IDEA
 */

public class SetZeroes_73 {
    /**
     * Leave first row and column as the sign to mark which row and column needs to be set 0.
     * Two boolean value to record if first row and column needs to be set as 0.
     *
     * @param matrix given matrix
     */
    public void setZeroes(int[][] matrix) {

        /* Use 2 boolean to mark whether first row and column needs to be set 0 */
        boolean row0 = false;
        boolean col0 = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        col0 = true;
                    }
                    if (j == 0) {
                        row0 = true;
                    }

                    /* Mark which row and column needs to be set 0 */
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;

                }
            }
        }

        /* Set 0 for each needed row and column except first row and column */
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        /* First column and row */
        if (row0) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        if (col0) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }

        System.out.println(Arrays.deepToString(matrix));
    }
}
