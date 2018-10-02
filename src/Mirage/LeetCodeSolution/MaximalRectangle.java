package Mirage.LeetCodeSolution;

import java.util.Stack;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 * Example:
 * Input:
 * [
 * ["1","0","1","0","0"],
 * ["1","0","1","1","1"],
 * ["1","1","1","1","1"],
 * ["1","0","0","1","0"]
 * ]
 * Output: 6
 *
 * @author BorisMirage
 * Time: 2018/08/27 1:00 PM
 * Created with IntelliJ IDEA
 */

public class MaximalRectangle {
    /**
     * face
     *
     * @param matrix input int matrix
     * @return max area
     */
    public int maximalRectangle(char[][] matrix) {

        /* Special Case */
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int[] row = new int[matrix[0].length];


        for (int i = 0; i < row.length; i++) {
            if (matrix[0][i] == '1') {
                row[i] += 1;
            }
        }
        int max = largestRectangleArea(row);
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    row[j] += 1;
                } else {
                    row[j] = 0;
                }
            }
            max = Math.max(max, largestRectangleArea(row));
        }
        return max;
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> temp = new Stack<>();
        int maxArea = 0;
        int h;

        for (int i = 0; i <= heights.length; i++) {

            /* Set each calculation's bar height. If out of bound, set 0 to pop all elements in stack. */
            h = (i == heights.length ? 0 : heights[i]);
            if (temp.empty() || h > heights[temp.peek()]) {

                /* Push index into stack to record position */
                temp.push(i);

            } else {
                int top = temp.pop();
                maxArea = Math.max(maxArea, heights[top] * (temp.empty() ? i : i - 1 - temp.peek()));

                /* i - 1 so that the highest bar can be pushed to the end of stack */
                i--;
            }
        }

        return maxArea;
    }
}
