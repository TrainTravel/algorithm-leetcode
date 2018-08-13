package Olivia;

public class GenerateMatrix59 {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        /* special case for n=0 */
        if (n == 0)
            return result;
        int leftMax = 0;
        int rightMax = n - 1;
        int upMax = 0;
        int downMax = n - 1;
        int num = 1;
        /* go four directions from right, to down, to left, and to up ........ */
        while (leftMax <= rightMax && upMax <= downMax) {
            //go left
            for (int i = leftMax; i <= rightMax; i++) {
                result[upMax][i] = num;
                num++;
            }
            upMax++;
            //go down
            for (int i = upMax; i <= downMax; i++) {
                result[i][rightMax] = num;
                num++;
            }
            rightMax--;
            //go left
            for (int i = rightMax; i >= leftMax; i--) {
                result[downMax][i] = num;
                num++;
            }
            downMax--;
            //go up
            for (int i = downMax; i >= upMax; i--) {
                result[i][leftMax] = num;
                num++;
            }
            leftMax++;
        }
        return result;

    }
}
