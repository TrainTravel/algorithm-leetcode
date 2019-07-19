package Solution.DFS;

import Lib.Tree.TreeNode;

/**
 * You are given a binary tree in which each node contains an integer value.
 * Find the number of paths that sum to a given value.
 * The path must go downwards (traveling only from parent nodes to child nodes), no other specific requirement.
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 *
 * @author BorisMirage
 * Time: 2019/03/25 10:33
 * Created with IntelliJ IDEA
 */

public class PathSum_437 {
    /**
     * DFS recursion.
     *
     * @param root root node
     * @param sum  target sum
     * @return number of path that sum equals given int
     */
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    /**
     * DFS recursion.
     * Path contains:
     * 1. path from previous node to current node
     * 2. path start from current node to left child node.
     * 3. path start from current node to right child node.
     *
     * @param n   current node
     * @param sum given sum
     * @return number of path equal to given int until current node
     */
    private int dfs(TreeNode n, int sum) {
        if (n == null) {
            return 0;
        }

        return (n.val == sum ? 1 : 0) + dfs(n.left, sum - n.val) + dfs(n.right, sum - n.val);
    }
}
