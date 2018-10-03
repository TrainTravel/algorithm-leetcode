package Mirage.LeetCodeSolution;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * @author BorisMirage
 * Time: 2018/10/02 20:22
 * Created with IntelliJ IDEA
 */

public class InorderTraversal {
    /**
     * Simply follow the inorder traversal rule. Use stack to temporary store node during the process.
     *
     * @param root root node
     * @return inorder traversal node value
     */
    public List<Integer> inorderTraversal(TreeNode root) {

        LinkedList<Integer> res = new LinkedList<>();

        Stack<TreeNode> temp = new Stack<>();
        TreeNode cur = root;
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
