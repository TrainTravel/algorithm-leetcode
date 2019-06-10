package Solution.Search;

import Lib.Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
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

        /* Corner case */
        if (n == 0) {
            return res;
        }

        return generate(1, n);
    }

    /**
     * Generate BST.
     *
     * @param start start int
     * @param end   end int
     * @return generate all structurally unique BST
     */
    private List<TreeNode> generate(int start, int end) {
        List<TreeNode> out = new ArrayList<>();

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

        for (int i = start; i <= end; i++) {        // select every i as root node

            left = generate(start, i - 1);      // left: less than i
            right = generate(i + 1, end);       // right: larger than i


            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    out.add(root);
                }
            }
        }

        return out;
    }
}
