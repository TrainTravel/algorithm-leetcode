package Solution.TwoPointers;

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
     * Use two pointers as left start pointer and right start pointer.
     * Move pointer toward center in iteration and add valid value to result.
     *
     * @param height int array of elevation map
     * @return trap space
     */
    public int trap(int[] height) {

        /* Corner case */
        if (height.length < 3) {
            return 0;
        }

        int res = 0;
        int left = 0;
        int right = height.length - 1;

        /* Find correct start and end bound
         * From left to right, find end of increasing order.
         * From right to left, find the end of decreasing order. */
        while (left < right && height[left] < height[left + 1]) {
            left++;
        }
        while (left < right && height[right] < height[right - 1]) {
            right--;
        }

        if (left >= right) {        // if no valid "pit" can be found
            return 0;
        }

        while (left < right) {

            /* Obtain each value in array.
             * If valid, add to result. */
            int leftValue = height[left];
            int rightValue = height[right];

            /* If left is smaller than right, then move left pointer.
             * Container is depended by smaller height */
            if (leftValue < rightValue) {

                /* Note: height[indexLeft + 1] can be replaced as height[++indexLeft].
                 * And the indexLeft++ needs to be removed.
                 * But only ++left rather than anything else.
                 * The reason is that ++indexLeft increments the number before the current expression is evaluated */
                while (left < right && leftValue > height[left + 1]) {
                    res += leftValue - height[left + 1];
                    left++;
                }
                left++;
            } else {
                while (left < right && rightValue > height[right - 1]) {
                    res += rightValue - height[right - 1];
                    right--;
                }
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Trap_42 trapTest = new Trap_42();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trapTest.trap(height));
    }
}
