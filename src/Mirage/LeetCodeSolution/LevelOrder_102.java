package Mirage.LeetCodeSolution;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author BorisMirage
 * Time: 2019/02/21 14:02
 * Created with IntelliJ IDEA
 */

public class LevelOrder_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> out = new LinkedList<>();

        if (root == null) {
            return out;
        }

        Queue<TreeNode> layer = new LinkedList<>();
        layer.offer(root);
        while (!layer.isEmpty()) {

            int size = layer.size();
            List<Integer> temp = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode c = layer.poll();
                if (c.left != null) {
                    layer.offer(c.left);
                }
                if (c.right != null) {
                    layer.offer(c.right);
                }
                temp.add(c.val);
            }
            out.add(temp);
        }

        return out;
    }
}
