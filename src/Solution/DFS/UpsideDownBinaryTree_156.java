package Solution.DFS;

import Lib.Tree.TreeNode;

/**
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty.
 * Flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes.
 * Return the new root.
 *
 * @author BorisMirage
 * Time: 2019/07/06 15:21
 * Created with IntelliJ IDEA
 */

public class UpsideDownBinaryTree_156 {
    /**
     * "Upside down" first is to turn previous left most child to new root node.
     * Then move previous root to its left child's right node, and move root's left child to new root's left.
     *
     * @param root root node
     * @return flipped tree
     */
    public TreeNode upsideDownBinaryTree(TreeNode root) {

        /* Corner case and end point */
        if (root == null || root.left == null && root.right == null) {
            return root;
        }

        TreeNode newRoot = upsideDownBinaryTree(root.left);     // return left most child node

        /* "Upside down" first is to turn previous left most child to new root node.
         * Then move previous root to its left child's right node, and move root's left child to new root's left. */
        root.left.left = root.right;
        root.left.right = root;

        root.left = null;       // in case this is the last level
        root.right = null;

        return newRoot;     // return current level root for next recursion
    }
}
