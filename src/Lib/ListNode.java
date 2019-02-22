package Lib;

/**
 * ListNode contains one single value.
 * "next" works as link function.
 * However, it DOES NOT save node, just virtually "link" current node to next node.
 */
public class ListNode {

    /* value of current node */
    public int val;

    /* Next linked node */
    public ListNode next;

    /**
     * @param x value that related to this current ListNode
     */
    public ListNode(int x) {
        val = x;
    }
}
