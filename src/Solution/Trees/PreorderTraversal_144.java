package Solution.Trees;

import Lib.Tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

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
        TreeNode current = root;

        Stack<TreeNode> s = new Stack<>();
        Queue<TreeNode> q = new LinkedList<>();

        while (current != null || !q.isEmpty() || !s.isEmpty()) {
            while (current != null) {
                q.offer(current);
                if (current.right != null) {
                    s.push(current.right);
                }
                current = current.left;
            }
            while (!q.isEmpty()) {
                out.add(q.poll().val);
            }
            if (!s.isEmpty()) {
                current = s.pop();
            }
        }
        return out;
    }
}
