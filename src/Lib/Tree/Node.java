package Lib.Tree;

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
    public Node parent;

    public Node() {
    }

    public Node(int val, Node left, Node right, Node next, Node parent) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}