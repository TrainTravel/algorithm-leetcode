package Solution.Graph;

import java.util.*;

/**
 * For an undirected graph with tree characteristics, we can choose any node as the root.
 * The result graph is then a rooted tree.
 * Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs).
 * Given such a graph, write a function to find all the MHTs and return a list of their root labels.
 * Format:
 * The graph contains n nodes which are labeled from 0 to n - 1.
 * You will be given the number n and a list of undirected edges (each edge is a pair of labels).
 * No duplicate edges will appear in edges.
 * Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 * Note:
 * 1. A tree is an undirected graph in which any two vertices are connected by exactly one path.
 * 2. The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
 *
 * @author BorisMirage
 * Time: 2019/05/30 10:07
 * Created with IntelliJ IDEA
 */

public class FindMinHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new LinkedList<>();
        if (n < 3) {
            for (int i = 0; i < n; i++) {
                result.add(i);
            }
            return result;
        }

        HashMap<Integer, Set<Integer>> m = new HashMap<>();
        for (int[] edge : edges) {
            m.putIfAbsent(edge[0], new HashSet<>());
            m.putIfAbsent(edge[1], new HashSet<>());
            m.get(edge[0]).add(edge[1]);
            m.get(edge[1]).add(edge[0]);

        }

        while (m.size() > 2) {
            Set<Integer> leaf = new HashSet<>();
            for (Integer integer : m.keySet()) {
                if (m.get(integer).size() < 2) {
                    leaf.add(integer);
                }
            }

            for (Integer integer : leaf) {
                m.remove(integer);
            }
            for (Integer i : m.keySet()) {
                m.get(i).removeAll(leaf);
            }
        }

        result.addAll(m.keySet());
//        System.out.println(m);

        return result;
    }

    public static void main(String[] args) {
        FindMinHeightTrees test = new FindMinHeightTrees();
        int[][] arr = {{0, 1}, {6, 1}, {7, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 8}};
        System.out.println(test.findMinHeightTrees(9, arr));
    }
}
