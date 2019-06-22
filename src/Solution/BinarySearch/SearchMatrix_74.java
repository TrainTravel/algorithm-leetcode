package Solution.BinarySearch;

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

        /* Corner case */
        if (matrix.length == 0) {
            return false;
        }

        int left = 0;
        int right = matrix.length * matrix[0].length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;
            int row = mid / matrix[0].length;
            int col = mid % matrix[0].length;

            if (matrix[row][col] == target) {
                return true;
            }
            if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
