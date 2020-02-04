package Playground;

import Lib.Tree.BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author BorisMirage
 * Time: 2019/03/23 12:55
 * Created with IntelliJ IDEA
 */

public class DFS {

    /**
     * Depth-first search implementation via tree node.
     *
     * @param root root node
     * @return all root-to-leaf paths
     */
    public List<List<Integer>> depthFirstSerch(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        dfs(root, res, new LinkedList<>());

        return res;
    }


    /**
     * Running DFS to find all root-to-leaf paths.
     *
     * @param r     current root node
     * @param res   path list
     * @param cache temporary path list
     * @return root-to-leaf paths
     */
    private List<List<Integer>> dfs(TreeNode r, List<List<Integer>> res, List<Integer> cache) {

        /* Add value into list as DFS process */
        cache.add(r.val);

        if (r.left == null && r.right == null) {
            res.add(new LinkedList<>(cache));

        } else {
            if (r.left != null) {
                dfs(r.left, res, cache);
            }
            if (r.right != null) {
                dfs(r.right, res, cache);
            }
        }

        cache.remove(cache.size() - 1);

        return res;

    }
}
