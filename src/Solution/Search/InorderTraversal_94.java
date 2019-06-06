package Solution.Search;

import Lib.Tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the in order traversal of its nodes' values.
 *
 * @author BorisMirage
 * Time: 2018/10/02 20:22
 * Created with IntelliJ IDEA
 */

public class InorderTraversal_94 {
    /**
     * Simply follow the in order traversal rule. Use stack to temporary store node during the process.
     *
     * @param root root node
     * @return in order traversal node value
     */
    public List<Integer> inorderTraversal(TreeNode root) {

        LinkedList<Integer> res = new LinkedList<>();
        Stack<TreeNode> temp = new Stack<>();
        TreeNode cur = root;

        /* Traverse process */
        while (cur != null || !temp.isEmpty()) {
            while (cur != null) {
                temp.add(cur);
                cur = cur.left;
            }
            cur = temp.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}
