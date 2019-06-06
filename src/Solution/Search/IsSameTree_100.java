package Solution.Search;

import Lib.Tree.TreeNode;

/**
 * Given two binary trees, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 *
 * @author BorisMirage
 * Time: 2018/10/02 12:10
 * Created with IntelliJ IDEA
 */

public class IsSameTree_100 {

    /**
     * Recursion.
     * If sub nodes do not be in same situation (null or not null), return false.
     * If value in tree node is same, continue recursion in sub nodes.
     *
     * @param p TreeNode 1
     * @param q TreeNode 2
     * @return if two trees are same
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }
}

