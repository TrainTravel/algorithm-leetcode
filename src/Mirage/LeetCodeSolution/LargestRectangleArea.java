package Mirage.LeetCodeSolution;

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
     * @param heights input histogram's bar height array
     * @return area of largest rectangle
     */
    public int largestRectangleArea(int[] heights) {
        
        if (heights.length==0){
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
}
