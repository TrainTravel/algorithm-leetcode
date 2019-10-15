package Solution.DFS;


import Lib.Tree.TreeNode;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * 1. The left subtree of a node contains only nodes with keys less than the node's key.
 * 2. The right subtree of a node contains only nodes with keys greater than the node's key.
 * 3. Both the left and right subtrees must also be binary search trees.
 *
 * @author BorisMirage
 * Time: 2018/10/06 16:13
 * Created with IntelliJ IDEA
 */

public class IsValidBST_98 {
    /**
     * In-order traversal with each root's value. Compare left subtree and right subtree.
     *
     * @param root root TreeNode
     * @return is this tree a BST
     */
    public boolean isValidBST(TreeNode root) {
        return recursion(root, Long.MIN_VALUE, Long.MAX_VALUE);     // avoid int overflow
    }

    /**
     * In-order traversal that compare root's value to left and right.
     *
     * @param root current root
     * @param min  min value
     * @param max  max value
     * @return is current root a BST
     */
    private boolean recursion(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val >= max || root.val <= min) {       // no duplicate node as well
            return false;
        }
        return recursion(root.left, min, root.val) && recursion(root.right, root.val, max);
    }

    /**
     * Inorder traversal.
     *
     * @param root root node
     * @return is this tree a BST
     */
    public boolean inOrder(TreeNode root) {

        /* Corner case */
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        long[] arr = new long[]{Long.MIN_VALUE};

        return helper(root, arr);
    }

    /**
     * In order traversal to traverse all nodes.
     * Inorder traversal can traverse all nodes by increasing order if the tree is a valid BST.
     *
     * @param r        current node
     * @param previous previous node value
     * @return is this tree a BST
     */
    private boolean helper(TreeNode r, long[] previous) {
        if (r == null) {
            return true;
        }

        boolean out;
        out = helper(r.left, previous);

        if ((long) r.val <= previous[0]) {
            return false;
        }

        previous[0] = r.val;

        return out & helper(r.right, previous);
    }
}
