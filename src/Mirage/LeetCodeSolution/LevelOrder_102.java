package Mirage.LeetCodeSolution;

import java.util.LinkedList;
import java.util.List;

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

        LinkedList<TreeNode> layer = new LinkedList<>();
        layer.add(root);
        while (!layer.isEmpty()) {

            int size = layer.size();
            List<Integer> temp = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode c = layer.getFirst();
                if (c.left != null) {
                    layer.addLast(c.left);
                }
                if (c.right != null) {
                    layer.addLast(c.right);
                }
                temp.add(c.val);
                layer.removeFirst();
            }
            out.add(temp);
        }

        return out;
    }
}
