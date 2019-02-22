package Solution.Array;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * @author BorisMirage
 * Time: 2018/06/04 10:20
 * Created with IntelliJ IDEA
 */

public class MaxArea_11 {
    /**
     * Since the max area is limited by the smaller int and the subtraction of two point's x coordinate,
     * Then start from the left and right two point.
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
            maxArea = Integer.max(maxArea, Integer.min(height[left], height[right]) * (right - left));
        }
        return maxArea;
    }

    public static void main(String[] args) {

        /* Max Area Test */
        int[] height = {1, 8, 3, 6, 8, 3, 5, 3};
        MaxArea_11 MaxAreaTest = new MaxArea_11();
        System.out.println(MaxAreaTest.MaxArea(height));
    }
}
