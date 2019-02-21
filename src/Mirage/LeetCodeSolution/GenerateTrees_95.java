package Mirage.LeetCodeSolution;

import java.util.LinkedList;
import java.util.List;

/**
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 * Example:
 * Input: 3
 * Output:
 * [
 * [1,null,3,2],
 * [3,2,null,1],
 * [3,1,null,null,2],
 * [2,1,3],
 * [1,null,2,null,3]
 * ]
 *
 * @author BorisMirage
 * Time: 2018/10/13 10:25
 * Created with IntelliJ IDEA
 */

public class GenerateTrees_95 {
    /**
     * Select each point from 1 to n as root, recursive generate each root's left sub tree and right sub tree.
     *
     * @param n given n
     * @return all combination of valid BST
     */
    public List<TreeNode> generateTrees(int n) {

        List<TreeNode> res = new LinkedList<>();

        /* Special Case */
        if (n == 0) {
            return res;
        }

        return generate(1, n);
    }

    private List<TreeNode> generate(int start, int end) {
        List<TreeNode> out = new LinkedList<>();

        /* End point */
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

            /* Generate sub tree recursively */
            left = generate(start, i - 1);
            right = generate(i + 1, end);

            /* Add nodes to tree */
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
