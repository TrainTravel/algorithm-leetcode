package Lib.Graph;

import java.util.List;

/**
 * Definition of graph.
 *
 * @author BorisMirage
 * Time: 2019/06/05 21:40
 * Created with IntelliJ IDEA
 */

public class Graph {
    public int val;
    public List<Graph> neighbor;

    /**
     * @param _val      value store in cache
     * @param _neighbor all linked node to current graph node
     */
    public Graph(int _val, List<Graph> _neighbor) {
        val = _val;
        neighbor = _neighbor;
    }
}
