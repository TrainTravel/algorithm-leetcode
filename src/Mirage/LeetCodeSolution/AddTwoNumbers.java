package Mirage.LeetCodeSolution;

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
 * @author BorisMirage
 * Time: 2017/11/24 12:26
 * Created with IntelliJ IDEA
 */


public class AddTwoNumbers {

    /**
     * Sum two nodes and return the sum node. Until List is empty
     *
     * @param l1 first int contains in ListNode
     * @param l2 second int contains in ListNode
     * @return result in ListNode
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return recursiveAdding(l1, l2, 0);
    }

    /**
     * Recursively add nodes until reach the end of list.
     *
     * @param l1  first node
     * @param l2  second node
     * @param sum previous sum
     * @return
     */
    public ListNode recursiveAdding(ListNode l1, ListNode l2, int sum) {

        /* Special case and end point */
        if (l1 == null && l2 == null && sum == 0) {
            return null;
        }

        if (l1 != null) {
            sum += l1.val;
        }
        if (l2 != null) {
            sum += l2.val;
        }

        ListNode current = new ListNode(sum % 10);
        current.next = recursiveAdding(l1 == null ? null : l1.next, l2 == null ? null : l2.next, sum / 10);
        return current;
    }
}


/**
 * ListNode contains one single value.
 * "next" works as link function.
 * <p>
 * However, it DOES NOT save node, just virtually "link" current node to next node.
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