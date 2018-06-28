package Mirage.LeetCodeSolution;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 6/27/18
 * Time: 14:18
 */

public class Trap {
    /**
     * Given n non-negative integers representing an elevation map where the width of each bar is 1.
     * Compute how much water it is able to trap after raining.
     * <p>
     * Use two int as pointer, to find bound of each "pit" and add to result.
     *
     * @param height int array that store map
     * @return trap space
     */
    public int trap(int[] height) {

        /* Special Case */
        if (height.length < 3) {
            return 0;
        }

        int res = 0;
        int indexLeft = 0;
        int indexRight = height.length - 1;

        /* Find correct start and end bound */
        while (indexLeft < indexRight && height[indexLeft] < height[indexLeft + 1]) {
            indexLeft++;
        }
        while (indexLeft < indexRight && height[indexRight] < height[indexRight - 1]) {
            indexRight--;
        }

        /* If no valid "pit" can be found */
        if (indexLeft >= indexRight) {
            return 0;
        }

        /* Traverse array to find all "pit" */
        while (indexLeft < indexRight) {

            /* Obtain each value in array. If valid, add to result. */
            int leftValue = height[indexLeft];
            int rightValue = height[indexRight];

            /* If left is smaller than right, then move left pointer since container is depended by smaller height */
            if (leftValue < rightValue) {
                while (indexLeft < indexRight && leftValue > height[indexLeft + 1]) {
                    res += leftValue - height[indexLeft + 1];
                    indexLeft++;
                }
                indexLeft++;
            } else {
                while (indexLeft < indexRight && rightValue > height[indexRight - 1]) {
                    res += rightValue - height[indexRight - 1];
                    indexRight--;
                }
                indexRight--;
            }
        }
        return res;
    }
}
