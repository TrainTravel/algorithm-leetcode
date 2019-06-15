package Solution.Trees;

import Lib.Tree.TreeNode;

/**
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST.
 * Return the root node reference (possibly updated) of the BST.
 * Basically, the deletion can be divided into two stages:
 * 1. Search for a node to remove.
 * 2. If the node is found, delete the node.
 * Note: Time complexity should be O(height of tree).
 *
 * @author BorisMirage
 * Time: 2019/06/15 13:20
 * Created with IntelliJ IDEA
 */

public class DeleteNode_450 {
    /**
     * The key is to handle the situation after find the node in BST.
     * First, recursively find the node that has the same value as the key.
     * Once the node is found, 4 cases should be considered:
     * node doesn't have left or right subtree -> return null
     * left subtree only -> return the left subtree, as they follow BST rule.
     * right subtree only -> return the right subtree, same as left subtree only
     * If node has two subtrees, the situation is complicated:
     * 1. right has no left tree -> left is smaller than right, replace node with root of right subtree.
     * 2. right has left subtree -> the left subtree will be the left subtree of smallest element in right subtree.
     * The reason is that all elements in left is smaller than right in BST, and right subtree is larger than root.
     * Therefore, to follow this rule, the parent of left subtree should be the smallest node in right subtree.
     * And the right subtree of this new root, is the original right subtree, except with this smallest node.
     *
     * @param root root node in tree
     * @param key  node to be delete
     * @return BST after delete operation
     */
    public TreeNode deleteNode(TreeNode root, int key) {

        /* Corner case */
        if (root == null) {
            return null;
        }

        /* Searching in tree */
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        }

        /* Find the target node and do the delete operation */
        if (root.left == null && root.right == null) {
            return null;        // no subtree on current node
        } else if (root.left == null) {
            return root.right;      // no left subtree
        } else if (root.right == null) {
            return root.left;       // no right subtree
        }

        if (root.right.left == null) {      // all elements in right subtree is larger than current node
            root.right.left = root.left;        // all elements in left subtree is smaller than right child
            return root.right;      // right child replace current node as root
        } else {

            TreeNode smallest = finSubtreeRoot(root.right);     // find leftmost node

            /* Smallest node in right tree will replace current root node */
            smallest.left = root.left;
            smallest.right = root.right;
            return smallest;
        }
    }

    /**
     * Find left most node in tree. In BST, leftmost node is smallest node in tree.
     *
     * @param root root node
     * @return leftmost node with its sub tree
     */
    private TreeNode finSubtreeRoot(TreeNode root) {
        TreeNode cur = root.left;
        TreeNode pre = root;
        while (cur.left != null) {
            pre = cur;
            cur = cur.left;
        }

        pre.left = cur.right;       // replace leftmost node with its right subtree (or null)

        return cur;
    }
}
