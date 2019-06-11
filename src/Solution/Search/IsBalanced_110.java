package Solution.Search;

import Lib.Tree.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as:
 * A binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * @author BorisMirage
 * Time: 2019/06/11 11:33
 * Created with IntelliJ IDEA
 */

public class IsBalanced_110 {
    /**
     * DFS traversal.
     *
     * @param root root node
     * @return if given tree is height-balanced
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return dfs(root) != -1;
    }

    /**
     * DFS traversal. If current tree has an imbalanced tree, return -1.
     * Otherwise return the height difference.
     *
     * @param root root node
     * @return if given tree is height-balanced
     */
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;       // null node has no height
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {      // left/right/current tree is not height-balanced
            return -1;      // sub tree is not height-balanced
        }

        return Math.max(left, right) + 1;       // depth + 1
    }
}
