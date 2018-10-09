package Mirage.LeetCodeSolution;

/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * @author BorisMirage
 * Time: 2018/10/09 16:28
 * Created with IntelliJ IDEA
 */

public class MaxDepth {
    /**
     * DFS with recursion, when there exist sub node, continue and find max depth of tree.
     *
     * @param root root node
     * @return max depth.
     */
    public int maxDepth(TreeNode root) {

        /* End point */
        if (root == null) {
            return 0;
        }
        int depth = 1;
        if (root.left != null || root.right != null) {

            /* Keep find left sub tree and right sub tree until reaches the end */
            depth += Integer.max(maxDepth(root.left), maxDepth(root.right));

        }
        return depth;
    }
}
