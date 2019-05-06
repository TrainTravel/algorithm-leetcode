package Solution.Matrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * A 2D array that contains 0, 1, 2 is given.
 * Find a point in grid to minimize the total distance from all 1 to this point.
 * Each 0 marks pass.
 * Each 1 marks start point that requires to count distance, but it CANNOT pass through.
 * Each 2 marks an obstacle that CANNOT pass through.
 * If there is a 1 that can not reach any other 1 in array, then there is no possibility to find this point, return -1.
 *
 * @author BorisMirage
 * Time: 2019/05/05 19:47
 * Created with IntelliJ IDEA
 */

public class ShortestDistance_317 {
    public int shortestDistance(int[][] grid) {
        if (grid.length == 0) {
            return -1;
        }

        Queue<int[]> q = new LinkedList<>();
        int r = grid.length;
        int c = grid[0].length;
        int total = 0;      // find total 1 on grid
        int[][] distance = new int[r][c];       // distance sum
        int[][] reach = new int[r][c];      // each 0 should be capable to reach every 1 on grid

        for (int[] ints : grid) {
            for (int j = 0; j < c; j++) {
                if (ints[j] == 1) {
                    total += 1;
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !bfs(grid, distance, total, reach, i, j)) {
                    return -1;      // if there is a 1 can not reach any other 1 in array, then no possibility
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 && reach[i][j] == total) {
                    min = Math.min(min, distance[i][j]);
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private boolean bfs(int[][] grid, int[][] d, int t, int[][] r, int x, int y) {

        /* Directions */
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int count = 0;      // count reachable 1, if count is not equal to total 1 on grid, then return false
        int level = 0;      // distance is determined by level in bfs
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];       // mark visited point

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});

        while (!q.isEmpty()) {
            int s = q.size();
            level++;

            /* Level iteration */
            for (int i = 0; i < s; i++) {
                int[] cur = q.remove();
                for (int j = 0; j < 4; j++) {

                    /* New coord */
                    int cx = cur[0] + dx[j];
                    int cy = cur[1] + dy[j];

                    /* Neighbour iteration */
                    if (cx > -1 && cy > -1 && cx < grid.length && cy < grid[0].length && !isVisited[cx][cy]) {
                        if (grid[cx][cy] == 0) {
                            d[cx][cy] += level;     // count sum of distance from each 1
                            r[cx][cy]++;            // 0 can be reach by current iteration
                            isVisited[cx][cy] = true;
                            q.offer(new int[]{cx, cy});
                        } else if (grid[cx][cy] == 1) {
                            count++;
                            isVisited[cx][cy] = true;
                        }
                    }
                }
            }
        }
        return count == t;
    }
}
