package Solution.BinarySearch;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * 1. Integers in each row are sorted in ascending from left to right.
 * 2. Integers in each column are sorted in ascending from top to bottom.
 *
 * @author BorisMirage
 * Time: 2019/06/23 17:23
 * Created with IntelliJ IDEA
 */

public class SearchMatrix_240 {

    /**
     * Binary search row and column to narrow the search range.
     *
     * @param matrix given 2D matrix
     * @param target target number
     * @return if target value in matrix
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;
        return search(matrix, target, 0, 0, matrix.length - 1, matrix[0].length - 1);
    }

    /**
     * Binary search.
     *
     * @param x1 row coordinate of top left element of the matrix
     * @param y1 column coordinate of top left elemeent of the matrix
     * @param x2 row coordinate of bottom right element of the matrix
     * @param y2 column coordinate of bottom right element of the matrix
     */
    private boolean search(int[][] matrix, int target, int x1, int y1, int x2, int y2) {
        if (x2 < x1 || y2 < y1 || x1 >= matrix.length || y1 >= matrix[0].length || x2 < 0 || y2 < 0) {
            return false;
        }
        int rowMid = (x2 - x1) / 2 + x1;
        int colMid = (y2 - y1) / 2 + y1;

        /*
         * Recursively call the binary search function to narrow the search range.
         * Each time reduce half of the row and column.
         * Finally, if the target value is not found in the end, return false.
         * */
        if (matrix[rowMid][colMid] == target) {
            return true;
        } else if (matrix[rowMid][colMid] < target) {       // search in bottom left and bottom right
            return (search(matrix, target, x1, colMid + 1, x2, y2) || search(matrix, target, rowMid + 1, y1, x2, colMid));
        } else if (matrix[rowMid][colMid] > target) {       // search in upper left and upper right
            return (search(matrix, target, x1, y1, x2, colMid - 1) || search(matrix, target, x1, colMid, rowMid - 1, y2));
        }
        return false;
    }
}
