package Solution.Matrix;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent.
 * The "Pacific" touches the left and top edges of the matrix and the "Atlantic" touches the right and bottom edges.
 * Water can only flow in four directions (up, down, left, or right) with height equal or lower.
 * Find the list of grid coordinates where water can flow to both the Pacific and Atlantic.
 * Note:
 * The order of returned grid coordinates does not matter.
 * Both m and n are less than 150.
 *
 * @author BorisMirage
 * Time: 2019/05/28 12:54
 * Created with IntelliJ IDEA
 */

public class PacificAtlantic_417 {
    /**
     * Add all points next to edge
     *
     * @param matrix given grid
     * @return all points that could move to diagonal edges
     */
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new LinkedList<>();

        /* Special case */
        if (matrix.length == 0) {
            return res;
        }

        boolean[][] visitedPacific = new boolean[matrix.length][matrix[0].length];
        boolean[][] visitedAtlantic = new boolean[matrix.length][matrix[0].length];
        Queue<int[]> Pacific = new LinkedList<>();
        Queue<int[]> Atlantic = new LinkedList<>();

        for (int i = 0; i < matrix.length; i++) {
            Pacific.add(new int[]{i, 0});
            Atlantic.add(new int[]{i, matrix[0].length - 1});
            visitedPacific[i][0] = true;
            visitedAtlantic[i][matrix[0].length - 1] = true;
        }

        for (int i = 0; i < matrix[0].length; i++) {
            Pacific.add(new int[]{0, i});
            Atlantic.add(new int[]{matrix.length - 1, i});
            visitedPacific[0][i] = true;
            visitedAtlantic[matrix.length - 1][i] = true;
        }

        bfs(visitedPacific, matrix, Pacific);
        bfs(visitedAtlantic, matrix, Atlantic);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (visitedPacific[i][j] && visitedAtlantic[i][j]) {
                    res.add(new int[]{i, j});
                }
            }
        }

        return res;
    }

    private void bfs(boolean[][] isVisited, int[][] matrix, Queue<int[]> q) {
        int[] xy = {1, -1, 0, 0, 1, -1, 0, 0};
        while (!q.isEmpty()) {
            int[] c = q.remove();
            int x = c[0];
            int y = c[1];
            for (int i = 0; i < 4; i++) {
                int xx = x + xy[i];
                int yy = y + xy[i + 4];
                if (xx > -1 && xx < matrix.length && yy > -1 && yy < matrix[0].length && !isVisited[xx][yy] && matrix[xx][yy] >= matrix[x][y]) {
                    q.add(new int[]{xx, yy});
                    isVisited[xx][yy] = true;
                }
            }
        }
    }
}
