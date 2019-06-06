package Solution.List;

import Lib.ListNode;

/**
 * Two non-empty linked lists are given to represent two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * @author BorisMirage
 * Time: 2017/11/24 12:26
 * Created with IntelliJ IDEA
 */


public class AddTwoNumbers_2 {

    /**
     * Sum two nodes and return the sum node until List is empty.
     *
     * @param l1 first int contains in ListNode
     * @param l2 second int contains in ListNode
     * @return result in ListNode
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return helper(l1, l2, 0);
    }

    /**
     * Add non-empty nodes recursively until all nodes in two lists are reached.
     * Use a int to save carry for next calculation.
     *
     * @param n1    first node
     * @param n2    second node
     * @param carry carry from previous sum
     * @return sum of two nodes
     */
    public ListNode helper(ListNode n1, ListNode n2, int carry) {

        /* Corner case and end point */
        if (n1 == null && n2 == null && carry == 0) {
            return null;
        }

        if (n1 != null) {
            carry += n1.val;
        }
        if (n2 != null) {
            carry += n2.val;
        }

        ListNode current = new ListNode(carry % 10);        // create a node to store this digit
        current.next = helper(n1 == null ? null : n1.next, n2 == null ? null : n2.next, carry / 10);
        return current;
    }
}


