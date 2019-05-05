package Solution.Matrix;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 * The distance between two adjacent cells is 1.
 *
 * @author BorisMirage
 * Time: 2019/05/05 19:07
 * Created with IntelliJ IDEA
 */

public class UpdateMatrix_542 {
    /**
     * Mark each 1 to Integer.MAX_VALUE.
     *
     * @param matrix given 2D int array
     * @return matrix with distance
     */
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix.length == 0) {
            return matrix;
        }
        Queue<int[]> l = new LinkedList<>();
        int r = matrix.length;
        int c = matrix[0].length;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    l.offer(new int[]{i, j});
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        while (!l.isEmpty()) {
            int[] t = l.remove();
            int x = t[0];
            int y = t[1];

            if (x + 1 < r && matrix[x + 1][y] > 0 && (matrix[x + 1][y] > matrix[x][y] + 1)) {
                l.add(new int[]{x + 1, y});
                matrix[x + 1][y] = matrix[x][y] + 1;
            }

            if (x - 1 > -1 && matrix[x - 1][y] > 0 && (matrix[x - 1][y] > matrix[x][y] + 1)) {
                l.add(new int[]{x - 1, y});
                matrix[x - 1][y] = matrix[x][y] + 1;
            }
            if (y + 1 < c && matrix[x][y + 1] > 0 && (matrix[x][y + 1] > matrix[x][y] + 1)) {
                l.add(new int[]{x, y + 1});
                matrix[x][y + 1] = matrix[x][y] + 1;
            }
            if (y - 1 > -1 && matrix[x][y - 1] > 0 && (matrix[x][y - 1] > matrix[x][y] + 1)) {
                l.add(new int[]{x, y - 1});
                matrix[x][y - 1] = matrix[x][y] + 1;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        int[][] r = {{0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}};
        UpdateMatrix_542 test = new UpdateMatrix_542();
        System.out.println(Arrays.deepToString(test.updateMatrix(r)));
        ;
    }
}
