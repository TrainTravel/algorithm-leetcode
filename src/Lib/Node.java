package Lib;

/**
 * @author BorisMirage
 * Time: 2019/04/28 17:34
 * Created with IntelliJ IDEA
 */

public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}