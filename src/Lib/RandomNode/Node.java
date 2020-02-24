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

    /**
     * Constructor of node.
     */
    public Node() {
    }

    /**
     * Overload of constructor.
     *
     * @param val    value in node
     * @param next   next node
     * @param random next random node
     */
    public Node(int val, Node next, Node random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }
};
