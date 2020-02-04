package Solution.DFS;

import Lib.Tree.BinaryTree.TreeNode;

/**
 * Given a binary tree, find the length of the longest consecutive sequence path.
 * Path refers to any sequence of nodes from starting node to any node in the tree along the parent-child connections.
 * The longest consecutive path need to be from parent to child (cannot be the reverse).
 *
 * @author BorisMirage
 * Time: 2019/06/12 15:21
 * Created with IntelliJ IDEA
 */

public class LongestConsecutive_298 {

//    private int max = 0;        // global max
//
//    /**
//     * DFS traversal.
//     *
//     * @param root root node
//     * @return length of longest consecutive path
//     */
//    public int longestConsecutive(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        dfs(root, root.val, 0);
//        return max;
//    }
//
//    /**
//     * Check nodes if current node value is equal to target value (previous node value + 1).
//     * If not matched, reset local max path length to 1 and keep doing DFS.
//     *
//     * @param r          root node
//     * @param val        value of consecutive path
//     * @param currentMax current max length of consecutive path
//     */
//    private void dfs(TreeNode r, int val, int currentMax) {
//
//        /* End point */
//        if (r == null) {
//            return;
//        }
//
//        currentMax = (r.val == val ? currentMax + 1 : 1);       // reset current max to 1 if value is not matched
//
//        max = Math.max(max, currentMax);
//
//        dfs(r.left, r.val + 1, currentMax);
//        dfs(r.right, r.val + 1, currentMax);
//    }

    private int max = 1;

    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);

        return max;
    }

    private int dfs(TreeNode r) {
        if (r == null) {
            return 0;
        }

        int left = dfs(r.left);
        int right = dfs(r.right);
        int local = 1;

        if (r.left != null && r.left.val == r.val + 1) {
            local = Math.max(left + 1, local);
        }
        if (r.right != null && r.right.val == r.val + 1) {
            local = Math.max(right + 1, local);
        }

        max = Math.max(local, max);

        return local;
    }
}
