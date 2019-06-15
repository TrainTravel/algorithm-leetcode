package Solution.Trees;

import Lib.Tree.TreeNode;

/**
 * Given the root node of a binary search tree (BST) and a value to be inserted into the tree, insert it into the BST.
 * Return the root node of the BST after the insertion.
 * It is guaranteed that the new value does not exist in the original BST.
 * Note that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion.
 *
 * @author BorisMirage
 * Time: 2019/06/15 14:33
 * Created with IntelliJ IDEA
 */

public class InsertIntoBST_701 {
    /**
     * Insert new node to correct subtree of leaf.
     *
     * @param root root node
     * @param val  value to be insert
     * @return BST with inserted value
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {

        /* Corner case and end point */
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
