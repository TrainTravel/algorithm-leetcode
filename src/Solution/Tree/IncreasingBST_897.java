package Solution.Tree;

import Lib.TreeNode;

/**
 * @author BorisMirage
 * Time: 2019/02/28 12:52
 * Created with IntelliJ IDEA
 */

public class IncreasingBST_897 {
    private TreeNode p = null, r = null;

    public TreeNode increasingBST(TreeNode root) {

        if (root == null) {
            return null;
        }

        increasingBST(root.left);
        if (p != null) {
            root.left = null;
            p.right = root;
        }
        if (r == null) {
            r = root;        // init this tree
        }
        p = root;
        increasingBST(root.right);
        return r;
    }
}
