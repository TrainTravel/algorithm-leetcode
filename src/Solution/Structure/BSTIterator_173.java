package Solution.Structure;

import Lib.Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Implement an iterator over a binary search tree (BST). It will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * Note:
 * 1. next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * 2. next() call will always be valid. There will be at least a next smallest number in the BST when next() is called.
 *
 * @author BorisMirage
 * Time: 2019/06/13 16:21
 * Created with IntelliJ IDEA
 */

public class BSTIterator_173 {
    private TreeNode root;
    Queue<Integer> q = new LinkedList<>();

    /**
     * Implement a In-order traversal.
     *
     * @param root given root node
     */
    public BSTIterator_173(TreeNode root) {
        this.root = root;
        inorder(root);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        if (!q.isEmpty()) {
            return q.poll();
        }
        return -1;

    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !q.isEmpty();

    }

    /**
     * Implement in-order traversal to save elements into a list.
     *
     * @param r root node
     * @return list contains all nodes in tree
     */
    private Queue<Integer> inorder(TreeNode r) {

//        LinkedList<Integer> res = new LinkedList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;

        /* Traverse process */
        while (cur != null || !s.isEmpty()) {

            while (cur != null) {
                s.add(cur);
                cur = cur.left;
            }

            cur = s.pop();
            q.add(cur.val);
            cur = cur.right;
        }

        return q;
    }
}
