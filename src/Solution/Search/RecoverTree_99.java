package Solution.Search;

import Lib.TreeNode;

/**
 * Two random elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 *
 * @author BorisMirage
 * Time: 2019/02/22 22:58
 * Created with IntelliJ IDEA
 */

public class RecoverTree_99 {

    private TreeNode a = null;
    private TreeNode b = null;
    private TreeNode temp = new TreeNode(Integer.MIN_VALUE);        // avoid null when "root" node is the deepest left node

    /**
     * The factor is to find two "root" nodes to swap.
     * Therefore, use in order traversal would found the incorrect left node and then incorrect right node.
     * This equals to add a "check" operation between two sub nodes.
     *
     * @param root root node of tree
     */
    public void recoverTree(TreeNode root) {
        traverse(root);

        /* Swap incorrect value */
        a.val = a.val + b.val;
        b.val = a.val - b.val;
        a.val = a.val - b.val;
    }

    /**
     * In order traversal.
     *
     * @param r temp root node
     */
    private void traverse(TreeNode r) {
        if (r == null) {
            return;
        }

        traverse(r.left);

        if (a == null && temp.val >= r.val) {
            a = temp;      // left incorrect node, based on in order traversal (left -> root -> right)
        }
        if (a != null && temp.val >= r.val) {
            b = r;      // right incorrect node, based on in order traversal (left -> root -> right)
        }

        temp = r;
        traverse(r.right);
    }
}
