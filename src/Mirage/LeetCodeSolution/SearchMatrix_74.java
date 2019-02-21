package Mirage.LeetCodeSolution;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row (increasing order).
 *
 * @author BorisMirage
 * Time: 2018/08/07 23:08
 * Created with IntelliJ IDEA
 */

public class SearchMatrix_74 {
    /**
     * Treat whole matrix as a sorted list, then use binary search to find target.
     * Be care of corner case such as empty matrix {}, {{}}.
     *
     * @param matrix input matrix
     * @param target target int
     * @return if target is in matrix
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        /* Special Case */
        if (matrix.length == 0) {
            return false;
        }

        /* Binary search */
        int s = 0;
        int e = matrix.length * matrix[0].length - 1;
        int c = matrix[0].length;
        while (s <= e) {
            int m = (s + e) / 2;

            /* Find correct position of mid int index in matrix */
            if (target == matrix[m / c][m % c]) {
                return true;
            }
            if (target > matrix[m / c][m % c]) {
                s = m + 1;
            }
            if (target < matrix[m / c][m % c]) {
                e = m - 1;
            }
        }
        return false;
    }
}
