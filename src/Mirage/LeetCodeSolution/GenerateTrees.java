package Mirage.LeetCodeSolution;

import java.util.LinkedList;
import java.util.List;

/**
 * @author BorisMirage
 * Time: 2018/10/13 10:25
 * Created with IntelliJ IDEA
 */

public class GenerateTrees {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new LinkedList<>();

        if (n == 0) {
            return res;
        }

        return generate(1, n);
    }

    private List<TreeNode> generate(int start, int end) {
        List<TreeNode> out = new LinkedList<>();
        if (start > end) {
            out.add(null);
            return out;
        }
        if (start == end) {
            out.add(new TreeNode(start));
            return out;
        }

        List<TreeNode> left;
        List<TreeNode> right;

        for (int i = start; i <= end; i++) {
            left = generate(start, i - 1);
            right = generate(i + 1, end);

            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    out.add(root);
                }
            }
        }
        return out;
    }
}
