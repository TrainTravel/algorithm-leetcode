package Mirage.LeetCodeSolution;


/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1.
 * Compute how much water it is able to trap after raining.
 *
 * @author BorisMirage
 * Time: 2018/06/27 14:18
 * Created with IntelliJ IDEA
 */

public class Trap_42 {
    /**
     * Use two int as left start pointer and right start pointer.
     * Move pointer toward center in iteration and add valid value to result.
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

                /* Note: height[indexLeft + 1] can be replaced as height[++indexLeft].
                 * And the indexLeft++ needs to be removed.
                 * But only ++left rather than anything else.
                 * The reason is that ++indexLeft increments the number before the current expression is evaluated */
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
