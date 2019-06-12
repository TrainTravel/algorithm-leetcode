package Solution.Search;

import Lib.Tree.TreeNode;

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

    private int max = 0;        // global max

    /**
     * DFS traversal.
     *
     * @param root root node
     * @return length of longest consecutive path
     */
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, root.val, 0);
        return max;
    }

    /**
     * Check nodes if current node value is equal to target value (previous node value + 1).
     * If not matched, reset local max path length to 1 and keep doing DFS.
     *
     * @param r          root node
     * @param val        value of consecutive path
     * @param currentMax current max length of consecutive path
     */
    private void dfs(TreeNode r, int val, int currentMax) {

        /* End point */
        if (r == null) {
            return;
        }

        currentMax = (r.val == val ? currentMax + 1 : 1);       // reset current max to 1 if value is not matched

        max = Math.max(max, currentMax);

        dfs(r.left, r.val + 1, currentMax);
        dfs(r.right, r.val + 1, currentMax);
    }
}
