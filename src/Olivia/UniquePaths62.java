package Olivia;

public class UniquePaths62 {
    public int uniquePaths(int m, int n) {
        //special case for m=0||n=0
        if (m == 0 || n == 0)
            return 0;
        if (m == 1 || n == 1)
            return 1;
        int[][] tmp = new int[m][n];
        tmp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0 && i - 1 < m) {
                    tmp[i][j] += tmp[i - 1][j];
                }
                if (j - 1 >= 0 && j - 1 < n) {
                    tmp[i][j] += tmp[i][j - 1];
                }

            }
        }
        return tmp[tmp.length - 1][tmp[0].length - 1];
    }
}
