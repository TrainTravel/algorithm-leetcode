package Solution.DFS;

import Lib.Tree.TreeNode;

/**
 * Given a binary tree, count the number of uni-value subtrees.
 * A Uni-value subtree means all nodes of the subtree have the same value.
 *
 * @author BorisMirage
 * Time: 2019/06/12 11:48
 * Created with IntelliJ IDEA
 */

public class CountUnivalSubtrees_250 {

    private int max = 0;        // global variant

    /**
     * DFS to iterate the tree and find every univalue tree.
     *
     * @param root root node
     * @return number of uni-value subtrees
     */
    public int countUnivalSubtrees(TreeNode root) {

        /* Corner case */
        if (root == null) {
            return 0;
        }

        isUnivalue(root);
        return max;
    }

    /**
     * If left and right subtree is univalue tree and root value equals to subtree, then current tree is univalue tree.
     *
     * @param r root
     * @return number of uni-value subtrees
     */
    private boolean isUnivalue(TreeNode r) {

        /* End point */
        if (r == null) {
            return true;        // leaf is counted as univalue tree
        }

        boolean left = isUnivalue(r.left);
        boolean right = isUnivalue(r.right);

        if (left && right) {
            if ((r.left != null && r.left.val != r.val) || (r.right != null && r.right.val != r.val)) {
                return false;
            }
            max++;
            return true;
        }
        return false;
    }
}
