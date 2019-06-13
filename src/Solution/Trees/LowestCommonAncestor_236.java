package Solution.Trees;

import Lib.Tree.TreeNode;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * LCA is defined between two nodes p and q as the lowest node in T that has both p and q as descendants.
 *
 * @author BorisMirage
 * Time: 2019/06/11 17:53
 * Created with IntelliJ IDEA
 */

public class LowestCommonAncestor_236 {
    /**
     * Three conditions:
     * 1. p and q are under same node -> LCA is the node
     * 2. One of p or q is the LCA -> LCA is p or q
     * 3. p and q are in different part of root's children -> LCA is root
     * These conditions can be also implemented in sub tree.
     * Do the DFS.
     * If one node is found in the left sub tree, then search in the right sub tree.
     * If the other node does not exist in right sub tree, then it is under the left sub tree.
     * Otherwise, LCA is the root of current recursion.
     *
     * @param root root node
     * @param p    first node
     * @param q    second node
     * @return lowest common ancestor (LCA) of two given nodes
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);      // search in left sub tree
        TreeNode right = lowestCommonAncestor(root.right, p, q);        // search in right sub tree

        if (left != null && right != null) {
            return root;        // found node in both left sub tree and right sub tree
        }
        return left == null ? right : left;     // it will exist
    }
}
