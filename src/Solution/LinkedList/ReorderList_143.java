package Solution.LinkedList;

import Lib.ListNode;

/**
 * Given a singly linked list L: L0 -> L1 -> ... -> Ln-1 -> Ln.
 * Reorder it to: L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2 -> ...
 *
 * @author BorisMirage
 * Time: 2019/06/29 14:34
 * Created with IntelliJ IDEA
 */

public class ReorderList_143 {
    /**
     * Reverse the second half of list, then insert every element into first half.
     *
     * @param head head node
     */
    public void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        ListNode last = head, middle = head;

        while (last.next != null && last.next.next != null) {
            middle = middle.next;
            last = last.next.next;
        }

        /* Reverse the second half of list.
         * Then insert every element in second half to first half. */
        ListNode dummy = middle;
        ListNode start = middle.next;
        while (start != null && start.next != null) {
            ListNode next = start.next;
            start.next = next.next;     // set to next start as dummy
            next.next = dummy.next;     // reverse node
            dummy.next = next;
        }

        middle = head;      // reset middle to head of list
        last = dummy.next;     // after reverse second half, p1 point at the end of list
        while (middle != dummy) {      // insert second half to first half
            dummy.next = last.next;
            last.next = middle.next;
            middle.next = last;
            middle = last.next;
            last = dummy.next;
        }
    }
}
