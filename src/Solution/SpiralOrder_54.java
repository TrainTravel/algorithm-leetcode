package Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * <p>
 * Example:
 * Input:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 * @author BorisMirage
 * Time: 2018/07/09 09:52
 * Created with IntelliJ IDEA
 */

public class SpiralOrder_54 {
    /**
     * Add elements into result list layer by layer.
     *
     * @param matrix input 2D array
     * @return elements in spiral order that store in List
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) {
            return res;
        }
        int topRow = 0;
        int leftColumn = 0;
        int bottomRow = matrix.length - 1;
        int rightColumn = matrix[0].length - 1;

        /* Add each layer into output list */
        while (topRow <= bottomRow && leftColumn <= rightColumn) {

            /* Add elements through top row, from left to right */
            for (int i = leftColumn; i <= rightColumn; i++) {
                res.add(matrix[topRow][i]);
            }

            /* Add elements through rightmost column in each layer, from top to bottom */
            for (int i = topRow + 1; i < bottomRow; i++) {
                res.add(matrix[i][rightColumn]);
            }

            /* Check if current layer exist bottom layer */
            if (topRow < bottomRow && leftColumn < rightColumn) {

                /* Add elements through bottom row, from right to left */
                for (int i = rightColumn - 1; i > leftColumn; i--) {
                    res.add(matrix[bottomRow][i]);
                }

                /* Add elements through leftmost column in each layer, from top to bottom */
                for (int i = bottomRow - 1; i > topRow; i--) {
                    res.add(matrix[i][leftColumn]);
                }
            }

            /* Move to next layer*/
            topRow++;
            bottomRow--;
            leftColumn++;
            rightColumn--;
        }

        return res;
    }
}
