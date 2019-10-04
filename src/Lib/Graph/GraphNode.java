package Lib.Graph;

import java.util.LinkedList;

/**
 * @author BorisMirage
 * Time: 2019/10/03 19:45
 * Created with IntelliJ IDEA
 */

public class GraphNode {
    int value;
    LinkedList<GraphNode> neighbor;

    public GraphNode(int val) {
        this.value = val;
        neighbor = new LinkedList<>();
    }
}
