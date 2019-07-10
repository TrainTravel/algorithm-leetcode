package Solution.BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * A m x n 2D grid initialized with these three possible values was given.
 * 1 - Obstacle.
 * 0 - Gate.
 * INF - Infinity, an empty room.
 * The value 2^31 - 1 = 2147483647 is used to represent INF - the distance to a gate is less than 2147483647.
 * Fill each empty room with the distance to its nearest gate.
 * If it is impossible to reach a gate, it should be filled with INF.
 *
 * @author BorisMirage
 * Time: 2019/05/05 15:33
 * Created with IntelliJ IDEA
 */

public class WallsAndGates_286 {

    /**
     * Find each cell that is 0. BFS based on each 0.
     *
     * @param rooms 2D int array
     */
    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0) {
            return;
        }
        Queue<int[]> l = new LinkedList<>();

        int r = rooms.length;
        int c = rooms[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                if (rooms[i][j] == 0) {     // find one door
                    l.offer(new int[]{i, j});

                }
            }
        }
        while (!l.isEmpty()) {
            int[] t = l.remove();
            int x = t[0];
            int y = t[1];

            if (x + 1 < r && rooms[x + 1][y] > 0 && (rooms[x + 1][y] == Integer.MAX_VALUE || rooms[x + 1][y] > rooms[x][y] + 1)) {
                l.add(new int[]{x + 1, y});
                rooms[x + 1][y] = rooms[x][y] + 1;
            }

            if (x - 1 > -1 && rooms[x - 1][y] > 0 && (rooms[x - 1][y] == Integer.MAX_VALUE || rooms[x - 1][y] > rooms[x][y] + 1)) {
                l.add(new int[]{x - 1, y});
                rooms[x - 1][y] = rooms[x][y] + 1;
            }
            if (y + 1 < c && rooms[x][y + 1] > 0 && (rooms[x][y + 1] == Integer.MAX_VALUE || rooms[x][y + 1] > rooms[x][y] + 1)) {
                l.add(new int[]{x, y + 1});
                rooms[x][y + 1] = rooms[x][y] + 1;
            }
            if (y - 1 > -1 && rooms[x][y - 1] > 0 && (rooms[x][y - 1] == Integer.MAX_VALUE || rooms[x][y - 1] > rooms[x][y] + 1)) {
                l.add(new int[]{x, y - 1});
                rooms[x][y - 1] = rooms[x][y] + 1;
            }
        }
    }

    public static void main(String[] args) {
        int[][] r = {{2147483647, -1, 0, 2147483647}, {2147483647, 2147483647, 2147483647, -1}, {2147483647, -1, 2147483647, -1}, {0, -1, 2147483647, 2147483647}};
        WallsAndGates_286 test = new WallsAndGates_286();
        test.wallsAndGates(r);
    }
}

