package Solution.Stack;

import java.util.Stack;

/**
 * Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.
 * Each number in the sequence is unique.
 *
 * @author BorisMirage
 * Time: 2019/06/27 16:06
 * Created with IntelliJ IDEA
 */

public class VerifyPreorder_255 {
    /**
     * If current element is smaller than top of stack, it is left subtree of all stack nodes, push the it into stack.
     * Update min value to current subtree's root when traverse to right subtree.
     *
     * @param preorder given array
     * @return whether it is the correct preorder traversal sequence of a binary search tree
     */
    public boolean verifyPreorder(int[] preorder) {
        int min = Integer.MIN_VALUE;
        Stack<Integer> s = new Stack<>();

        for (int i : preorder) {
            if (i < min) {      // if left subtree is smaller than root value, then it is invalid BST
                return false;
            }
            while (!s.empty() && i > s.peek()) {        // if i > s.peek() then i is in right subtree
                min = s.pop();      // update min value to current subtree's root when traverse to right subtree
            }
            s.push(i);
        }
        return true;
    }

    /**
     * Use array instead of stack to find root of subtree.
     *
     * @param preorder given array
     * @return whether it is the correct preorder traversal sequence of a binary search tree
     */
    private boolean constantSpace(int[] preorder) {
        int min = Integer.MIN_VALUE, i = -1;

        for (int num : preorder) {
            if (num < min) {
                return false;
            }
            while (i >= 0 && num > preorder[i]) {
                min = preorder[i--];        // in-place find root node of current right subtree
            }
            preorder[++i] = num;
        }
        return true;
    }

    public static void main(String[] args) {
        VerifyPreorder_255 test = new VerifyPreorder_255();
        System.out.println(test.verifyPreorder(new int[]{5, 2, 1, 3, 6}));
    }
}
