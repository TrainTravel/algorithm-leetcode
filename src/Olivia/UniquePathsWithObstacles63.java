package Olivia;

import sun.security.util.Length;

public class UniquePathsWithObstacles63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        /*special case for no grid*/
        if(obstacleGrid.length==0){
            return 0;
        }
        /*special case for exit and entry has block*/
        if(obstacleGrid[0][0]==1||obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]==1){
            return 0;
        }
        int[][]tmp = new int[obstacleGrid.length][obstacleGrid[0].length];
        tmp[0][0]=1;
        for(int i=0;i<obstacleGrid.length;i++){
            for(int j=0;j<obstacleGrid[0].length;j++){
                if(obstacleGrid[i][j]!=1){
                    if(i-1>=0&&i-1<obstacleGrid.length&&obstacleGrid[i-1][j]!=1){
                       tmp[i][j]+=tmp[i-1][j];
                    }
                    if(j-1>=0&&j-1<obstacleGrid[0].length&&obstacleGrid[i][j-1]!=1){
                        tmp[i][j] += tmp[i][j-1];
                    }
                }
            }
        }
        return tmp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}
