package Solution.Trees;

import Lib.Tree.TreeNode;

import java.util.*;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 *
 * @author BorisMirage
 * Time: 2019/06/27 10:52
 * Created with IntelliJ IDEA
 */

public class PreorderTraversal_144 {
    /**
     * Use a stack to store the right sub tree of current node.
     * Use a queue to store the root node and left sub tree.
     * Poll the queue until it is empty, then move current node to the top of stack. Repeat this process.
     *
     * @param root root node of tree
     * @return preorder traversal of tree's values
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> out = new LinkedList<>();

        if (root == null) {
            return out;
        }
        Deque<TreeNode> stack = new LinkedList<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                out.add(node.val);
                stack.push(node.right);
                stack.push(node.left);      // keep left at top of stack
            }
        }

        return out;
    }
}
