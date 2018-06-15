package LeetCodeSolution;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 11/24/17
 * Time: 12:26
 */


public class AddTwoNumbers {

    /**
     * You are given two non-empty linked lists representing two non-negative integers.
     * The digits are stored in reverse order and each of their nodes contain a single digit.
     * Add the two numbers and return it as a linked list.
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     * <p>
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     *
     * @param l1 first int contains in ListNode
     * @param l2 second int contains in ListNode
     * @return result in ListNode
     */
    /* Sum two nodes and return the sum node. Until List is empty */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode current = head;
        int carry = 0;

        while (l1 != null || l2 != null) {

            /* Get value for addition. */
            if (l1 != null) {
                carry = carry + l1.val;

            }
            if (l2 != null) {
                carry = carry + l2.val;

            }

            /* Sum and check carry */
            current.next = new ListNode(carry % 10);
            carry = carry / 10;
            current = current.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        return head.next;
    }
}


/**
 * ListNode contains one single value.
 * This class has "link" function, which is "next".
 * <p>
 * However, it DO NOT SAVE node, just virtually "link" current node to next node.
 * That is to say, it only "link" CURRENT status to NEXT status, and it is also a ListNode.
 */
class ListNode {

    /* value of current node */
    int val;

    /* Next linked node */
    ListNode next;

    /**
     * @param x value that related to this current ListNode
     */
    ListNode(int x) {
        val = x;
    }
}