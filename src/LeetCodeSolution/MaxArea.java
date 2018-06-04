package LeetCodeSolution;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 6/4/18
 * Time: 10:20
 */

public class MaxArea {
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
