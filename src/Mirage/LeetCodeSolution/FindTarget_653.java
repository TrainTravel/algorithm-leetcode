package Mirage.LeetCodeSolution;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Given a Binary Search_33 Tree and a target number.
 * Return true if there exist two elements in the BST such that their sum is equal to the given target.
 *
 * @author BorisMirage
 * Time: 2019/02/18 13:37
 * Created with IntelliJ IDEA
 */

public class FindTarget_653 {

    /**
     * Use two stacks to record left sub tree and right sub tree.
     * If sum is smaller than target, record left sub tree's right sub tree.
     * If sum is larger, do reversely.
     *
     * @param root root node
     * @param k    target
     * @return if the tree contains 2 elements that their sum is equal to k
     */
    public boolean findTarget_Stack(TreeNode root, int k) {

        Stack<TreeNode> ls = new Stack<>();
        Stack<TreeNode> rs = new Stack<>();

        for (TreeNode r = root; r != null; r = r.left) {
            ls.push(r);
        }
        for (TreeNode r = root; r != null; r = r.right) {
            rs.push(r);
        }

        while (ls.size() != 0 && rs.size() != 0 && ls.peek() != rs.peek()) {
            int temp = ls.peek().val + rs.peek().val;

            if (temp == k) {
                return true;
            } else if (temp < k) {
                for (TreeNode r = ls.pop().right; r != null; r = r.left) {
                    ls.push(r);
                }
            } else {
                for (TreeNode r = rs.pop().left; r != null; r = r.right) {
                    rs.push(r);
                }
            }
        }
        return false;
    }

    /**
     * DFS searchind and use set to store previously visited value.
     * If find a correct value, return true.
     * Note that this method is obviously faster than using stack.
     *
     * @param root root node
     * @param k    target
     * @return if the tree contains 2 elements that their sum is equal to k
     */
    public boolean findTarget_Set(TreeNode root, int k) {
        Set<Integer> temp = new HashSet<>();
        return dfs(root, k, temp);
    }

    /**
     * Recursively search the tree using DFS and find value.
     *
     * @param r currently root node
     * @param k target
     * @param s set that store previously visited value
     * @return true if find sum
     */
    private boolean dfs(TreeNode r, int k, Set<Integer> s) {
        if (r == null) {
            return false;
        }
        if (s.contains(k - r.val)) {
            return true;
        }
        s.add(r.val);
        return dfs(r.left, k, s) || dfs(r.right, k, s);
    }
}
