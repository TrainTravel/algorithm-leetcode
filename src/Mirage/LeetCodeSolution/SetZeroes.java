package Mirage.LeetCodeSolution;

import java.util.Arrays;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0.
 * Solve this problem in-place.
 *
 * @author BorisMirage
 * Time: 2018/08/07 15:55
 * Created with IntelliJ IDEA
 */

public class SetZeroes {
    /**
     * Mark as -1.
     *
     * @param matrix given matrix
     */
    public void setZeroes(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    /* Mark column */
                    for (int k = 0; k < matrix[0].length; k++) {
                        matrix[i][k] = -1;
                    }
                    for (int k = 0; k < matrix.length; k++) {
                        matrix[k][j] = -1;
                    }
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }
}
