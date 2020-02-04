package Lib.Tree.NaryTree;

import java.util.List;

/**
 * @author BorisMirage
 * Time: 2020/02/03 16:36
 * Created with IntelliJ IDEA
 */

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}