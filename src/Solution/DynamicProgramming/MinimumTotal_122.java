package Solution.DynamicProgramming;

import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to ADJACENT numbers on the row below.
 * For example, given the following triangle
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * @author BorisMirage
 * Time: 2019/01/15 10:32
 * Created with IntelliJ IDEA
 */

public class MinimumTotal_122 {

    /**
     * Bottom to top.
     *
     * @param triangle given triangle
     * @return min distance
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] temp = new int[triangle.size() + 1];

        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                temp[j] = Math.min(temp[j], temp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return temp[0];
    }

}
