package Lib.RandomNode;

/**
 * Node with random pointer, point to a random node in list.
 *
 * @author BorisMirage
 * Time: 2019/08/27 18:54
 * Created with IntelliJ IDEA
 */

public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {
    }

    public Node(int _val, Node _next, Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
