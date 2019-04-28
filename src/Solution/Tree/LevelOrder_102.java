package Solution.Tree;

import Lib.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values (from left to right, level by level).
 *
 * @author BorisMirage
 * Time: 2019/02/21 14:02
 * Created with IntelliJ IDEA
 */

public class LevelOrder_102 {

    /**
     * Use linked list to temporary store nodes.
     * Store root first, then add next level's node into last of list.
     * When traversing, pop first element in list and add its child node until this level completed.
     *
     * @param root root node of tree
     * @return level order traversal of its nodes' values
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> out = new LinkedList<>();

        if (root == null) {
            return out;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int s = q.size();
            List<Integer> level = new LinkedList<>();
            for (int i = 0; i < s; i++) {
                TreeNode temp = q.poll();
                if (temp != null) {
                    level.add(temp.val);
                    if (temp.left != null) {
                        q.add(temp.left);
                    }
                    if (temp.right != null) {
                        q.add(temp.right);
                    }
                }
            }
            out.add(level);
        }
        return out;
    }
}
