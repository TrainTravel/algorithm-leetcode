package Lib.Graph;

import java.util.List;

/**
 * Definition of graph.
 *
 * @author BorisMirage
 * Time: 2019/06/05 21:40
 * Created with IntelliJ IDEA
 */

public class Node {

    public int val;
    public List<Node> neighbors;

    public Node() {
    }

    /**
     * @param _val       value store in cache
     * @param _neighbors all linked node to current graph node
     */
    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
