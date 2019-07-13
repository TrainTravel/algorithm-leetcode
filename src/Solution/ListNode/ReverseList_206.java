package Solution.ListNode;

import Lib.ListNode;

/**
 * Reverse a singly linked list.
 *
 * @author BorisMirage
 * Time: 2019/07/13 10:19
 * Created with IntelliJ IDEA
 */

public class ReverseList_206 {
    /**
     * Iterative point current node to previous node, then move to next node.
     * Use a temp to save next start node during the iteration.
     *
     * @param head head of list
     * @return reversed list
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}
