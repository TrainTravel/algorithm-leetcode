package Mirage.LeetCodeSolution;

import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1.
 * Find the area of largest rectangle in the histogram.
 *
 * @author BorisMirage
 * Time: 2018/08/16 14:33
 * Created with IntelliJ IDEA
 */

public class LargestRectangleArea {

    /**
     * Faster solution with stack.
     * Traverse all elements in array.
     * Push elements in stack if it is increasing order.
     * If not, pop top of stack and regard current index position as smallest bar. Calculate area.
     * After each calculation, move index -1, since there is a possibility that current top is larger than smallest.
     *
     * @param heights input histogram's bar height array
     * @return area of largest rectangle
     */
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


    /**
     * Slow yet plain solution.
     * Traverse all elements in array.
     * In each round, find all elements that is larger than current bar. Calculate max area based on current bar.
     *
     * @param heights input histogram's bar height array
     * @return area of largest rectangle
     */
    public int largestRectangleAreaSlow(int[] heights) {

        if (heights.length == 0) {
            return 0;
        }

        /* Set min area */
        int maxArea = heights[0];

        for (int i = 0; i < heights.length; i++) {
            int l = i - 1;
            int r = i + 1;

            while (l >= 0 && heights[i] <= heights[l]) {
                l--;
            }

            while (r < heights.length && heights[i] <= heights[r]) {
                r++;
            }

            int temp = heights[i] * (r - l - 1);
            maxArea = Integer.max(maxArea, temp);
        }

        return maxArea;
    }


    public static void main(String[] args) {
        LargestRectangleArea largestRectangleAreaTest = new LargestRectangleArea();
        int[] arr = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleAreaTest.largestRectangleArea(arr));
    }

}
