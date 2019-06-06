package Solution.Search;

/**
 * Given a 2d grid map of '1's (land) and '0's (water)
 * Count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * All four edges of the grid are all surrounded by water.
 * i.e., if a land is at corner or edge of grid, it is counted as an island.
 *
 * @author BorisMirage
 * Time: 2019/06/05 11:40
 * Created with IntelliJ IDEA
 */

public class NumIslands_200 {
    /**
     * DFS.
     * When reaches a '1' then do DFS start at this point and mark all accessible point as visited.
     * Iterate all cells in grid.
     *
     * @param grid given grid
     * @return number of connected '1'
     */
    public int numIslands(char[][] grid) {
        int count = 0;

        /* Corner case */
        if (grid.length < 1) {
            return count;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == '1') {
                    count += 1;
                    grid[i][j] = '0';
                    backtracking(grid, i, j);
                }
            }
        }
        return count;
    }

    /**
     * Backtracking.
     *
     * @param grid given grid
     * @param i    coord x
     * @param j    coord y
     */
    private void backtracking(char[][] grid, int i, int j) {
        int[] direction = {1, -1, 0, 0, 0, 0, 1, -1};
        grid[i][j] = '0';

        for (int k = 0; k < 4; k++) {

            int nextX = i + direction[k];
            int nextY = j + direction[k + 4];

            if (nextX > -1 && nextX < grid.length && nextY > -1 && nextY < grid[0].length && grid[nextX][nextY] == '1') {
                backtracking(grid, nextX, nextY);
            }
        }
    }
}
