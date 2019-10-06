package Lib.Graph;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author BorisMirage
 * Time: 2019/10/03 19:45
 * Created with IntelliJ IDEA
 */

public class GraphNode {
    int value;
    LinkedList<GraphNode> neighbor;
    HashMap<GraphNode, Weight> weightHashMap;       // avoid duplicated in weight graph

    public GraphNode(int val) {
        this.value = val;
        neighbor = new LinkedList<>();
    }

    class Weight {
        int weight;
        GraphNode n1;
        GraphNode n2;

        public void setWeight(int weight) {
            this.weight = weight;
        }

    }
}
