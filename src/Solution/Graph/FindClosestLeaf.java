package Solution.Graph;

import Lib.Tree.TreeNode;

import java.util.*;

/**
 * Given a binary tree where every node has a unique value, and a target key k.
 * Find the value of the nearest leaf node to target k in the tree.
 * Nearest to a leaf means the least number of edges travelled on the binary tree to reach any leaf of the tree.
 * Also, a node is called a leaf if it has no children.
 * Note:
 * 1. root represents a binary tree with at least 1 node and at most 1000 nodes.
 * 2. Every node has a unique node.val in range [1, 1000].
 * 3. There exists some node in the given binary tree for which node.val == k.
 *
 * @author BorisMirage
 * Time: 2019/06/12 15:53
 * Created with IntelliJ IDEA
 */

public class FindClosestLeaf {
    /**
     * This is actually not a tree problem, it is a graph problem.
     * First do the dfs from root node to find node k in tree.
     * Then do BFS from node k to obtain the nearest leave node.
     * The is actually based on undirected graph, where nodes has a double-way connection with other nodes.
     *
     * @param root root node
     * @param k    target node
     * @return nearest leaf node to target k in the tree
     */
    public int findClosestLeaf_742(TreeNode root, int k) {

        HashMap<TreeNode, TreeNode> m = new HashMap<>();

        TreeNode target = dfs(root, k, m);

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();             // store all visited nodes
        q.add(target);
        visited.add(target);

        /* BFS to find nearest leaf node to target k in the tree */
        while (!q.isEmpty()) {
            TreeNode current = q.poll();

            if (current.left == null && current.right == null) {
                return current.val;
            }

            /* Add all connected nodes that has not visited before */
            if (current.left != null && visited.add(current.left)) {        // Set().add return false if element exists
                q.add(current.left);
            }
            if (current.right != null && visited.add(current.right)) {
                q.add(current.right);
            }
            if (m.containsKey(current) && visited.add(m.get(current))) {
                q.add(m.get(current));
            }
        }

        return -1;      // k is not found in tree (based on the problem description it will not happen)
    }

    /**
     * DFS to find k in tree.
     *
     * @param r root
     * @param k target
     * @param m hash map works as double linked list
     * @return node k in tree
     */
    private TreeNode dfs(TreeNode r, int k, HashMap<TreeNode, TreeNode> m) {
        if (r.val == k) {
            return r;
        }

        if (r.left != null) {
            m.put(r.left, r);
            TreeNode left = dfs(r.left, k, m);
            if (left != null) {
                return left;
            }
        }
        if (r.right != null) {
            m.put(r.right, r);
            return dfs(r.right, k, m);
        }
        return null;
    }
}
