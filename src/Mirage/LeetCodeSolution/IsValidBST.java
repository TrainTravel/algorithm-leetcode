package Mirage.LeetCodeSolution;

import java.util.LinkedList;
import java.util.Stack;

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

public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
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

        for (int i = 0; i < res.size() - 1; i++) {
            if (res.get(i) >= res.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
