package Solution.Trees;

import Lib.Tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * A full binary tree is a binary tree where each node has exactly 0 or 2 children.
 * Return a list of all possible full binary trees with N nodes.
 * Each element of the answer is the root node of one possible tree.
 * Each node of each tree in the answer must have node.val = 0.
 *
 * @author BorisMirage
 * Time: 2019/06/12 18:25
 * Created with IntelliJ IDEA
 */

public class AllPossibleFBT_894 {

    /**
     * Generate all subtrees with fixed size by recursively calling this function itself.
     *
     * @param N number of nodes in tree
     * @return list of all possible full binary trees with N nodes
     */
    public List<TreeNode> allPossibleFBT(int N) {

        List<TreeNode> out = new LinkedList<>();

        /* Corner case */
        if (N % 2 == 0) {
            return out;     // if N is even, there will always be one more node that violate FBT
        }
        if (N == 1) {
            out.add(new TreeNode(0));
            return out;
        }

        N--;

        for (int i = 1; i < N; i += 2) {        // construct all possible size of sub tree
            List<TreeNode> left = allPossibleFBT(N - i);
            List<TreeNode> right = allPossibleFBT(i);

            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode current = new TreeNode(0);
                    current.left = l;
                    current.right = r;
                    out.add(current);
                }
            }
        }
        return out;
    }
}
