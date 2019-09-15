package Solution.Graph;

import java.util.*;

/**
 * There are n servers numbered from 0 to n-1 connected by undirected server-to-server connections forming a network.
 * Any server can reach any other server directly or indirectly through the network.
 * A critical connection is a connection that, if removed, will make some server unable to reach some other server.
 * Return all critical connections in the network in any order.
 *
 * @author BorisMirage
 * Time: 2019/09/14 20:25
 * Created with IntelliJ IDEA
 */

public class CriticalConnections_1192 {
    /**
     * In Tarjan algorithm, keep two arrays DFN and LOW in DFS procedure.
     * DFN array records the order of DFS for each node, as an id assigned to each node.
     * LOW array records the lowest order of each node's neighbor except its direct parent.
     * Initially, LOW[i] equals to DFN[i].
     * After DFS, find edge(u,v) where DFN(u) < LOW(v) and get all the bridges.
     *
     * @param n           # of vertices
     * @param connections given list contains connections between nodes in graph
     * @return all critical connections in the network in any order
     */
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        Graph g = new Graph(n);
        g.addEdge(connections);

        return g.findBridge();
    }

    /**
     * Graph.
     */
    class Graph {
        private int V;      // # of vertices
        private ArrayList<ArrayList<Integer>> connections = new ArrayList<>();
        int time = 0;       // discover time (as increasing id for nodes)
        private List<List<Integer>> bridges = new LinkedList<>();

        /**
         * Constructor of graph.
         *
         * @param v # of vertices
         */
        Graph(int v) {
            V = v;
            for (int i = 0; i < v; i++) {
                connections.add(new ArrayList<>());
            }
        }

        /**
         * Add edges into graph.
         *
         * @param connections given list contains connections between nodes in graph
         */
        void addEdge(List<List<Integer>> connections) {
            for (List<Integer> list : connections) {
                this.connections.get(list.get(0)).add(list.get(1));
                this.connections.get(list.get(1)).add(list.get(0));
            }
        }

        /**
         * Find bridges in graph.
         *
         * @return bridges in this graph
         */
        List<List<Integer>> findBridge() {
            boolean[] isVisited = new boolean[V];
            int[] discovery = new int[V], low = new int[V], parent = new int[V];

            Arrays.fill(parent, -1);        // initially, all nodes has no parent

            for (int i = 0; i < V; i++) {
                if (!isVisited[i]) {
                    dfs(i, isVisited, discovery, low, parent);
                }
            }

            return bridges;
        }

        /**
         * DFS search to find bridge in graph.
         * If child node has only one path to current node's parent, then this edge is bridge in graph.
         * (low[vertex] > discovery[id])
         *
         * @param id        current node
         * @param isVisited boolean array records if current node has been visited
         * @param discovery discover time (as increasing id for nodes)
         * @param low       array records lowest parent that contains more than one path to current node
         * @param parent    parent of current node that direct connect to it
         */
        void dfs(int id, boolean[] isVisited, int[] discovery, int[] low, int[] parent) {
            isVisited[id] = true;
            discovery[id] = ++time;     // mark each node uniquely in order of reached time
            low[id] = ++time;           // initially, mark each node's lowest parent in order of reached time

            for (int vertex : connections.get(id)) {
                if (!isVisited[vertex]) {
                    parent[vertex] = id;
                    dfs(vertex, isVisited, discovery, low, parent);
                    low[id] = Math.min(low[id], low[vertex]);

                    /*
                     * low[vertex]: child node's lowest parent with more than one route to it.
                     * discovery[id]: current node id.
                     * If child node has only one path to current node's parent, then this edge is bridge in graph.
                     * Since there is only one way from current node's lowest parent to this child. */
                    if (low[vertex] > discovery[id]) {
                        ArrayList<Integer> tmp = new ArrayList<>();
                        tmp.add(id);
                        tmp.add(vertex);
                        bridges.add(tmp);
                    }
                } else if (vertex != parent[id]) {
                    low[id] = Math.min(low[id], discovery[vertex]);
                }
            }
        }
    }
}



