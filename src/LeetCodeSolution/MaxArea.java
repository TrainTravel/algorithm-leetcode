package LeetCodeSolution;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 6/4/18
 * Time: 10:20
 */

public class MaxArea {
    /**
     * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
     * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
     * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
     *
     * Since the max area is limited by the smaller int and the subtraction of two point's x coordinate,
     * then start from the left and right two point.
     * When shorter value is found, compare two area and find the larger one.
     * Repeat this process until two points are same point
     *
     * @param height input height int array
     * @return max area
     */
    public int MaxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = Integer.min(height[left], height[right]) * (right - left);
        while (left < right) {
            if (height[left] < height[right]) {
                left += 1;
            } else {
                right -= 1;
            }
            maxArea = Integer.max(maxArea, Integer.min(height[left], height[right])* (right - left));
        }
        return maxArea;
    }
}
