package Solution.DynamicProgramming;

import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to ADJACENT numbers on the row below.
 *
 * @author BorisMirage
 * Time: 2019/01/15 10:32
 * Created with IntelliJ IDEA
 */

public class MinimumTotal_120 {

    /**
     * Dynamic programming that find path from bottom to top.
     * Note that only adjacent numbers on the row below is reachable.
     * Therefore, simply compare two adjacent element will suffice.
     *
     * @param triangle given triangle
     * @return min distance
     */
    public int minimumTotal(List<List<Integer>> triangle) {

        /* Corner case */
        if (triangle.size() == 0) {
            return 0;
        }

        int[] dp = new int[triangle.get(triangle.size() - 1).size()];       // get last level of triangle

        for (int i = 0; i < triangle.get(triangle.size() - 1).size(); i++) {
            dp[i] = triangle.get(triangle.size() - 1).get(i);       // fill value with last level of triangle
        }

        for (int i = triangle.size() - 2; i > -1; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }

        return dp[0];
    }

}
