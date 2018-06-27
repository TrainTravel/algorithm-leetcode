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
     * Use two int as pointer, to find bound of each "pit" and use stack to store store capability.
     *
     * @param height int array that store map
     * @return trap space
     */
    public int trap(int[] height) {

        /* Special Case */
        if (height.length < 3) {
            return 0;
        }

        int s = 0;
        int res = 0;

        /* Traverse array to find start point */
        while (s < height.length && height[s] == 0) {
            s++;
        }
        while (s < height.length - 1 && height[s] < height[s + 1]) {
            s++;
        }

        if (s > height.length - 3) {
            return 0;
        }

        /* Use stack to store space */
        Stack<Integer> storeStack = new Stack<>();

        int start = s;

        /* Traverse array to find each "pit" */
        for (int i = s; i < height.length - 1; i++) {
            if (height[i] > height[i + 1]) {
                while ()
            }
        }

        return res;
    }
}
