package Solution.TwoPointers;

import Lib.ListNode.ListNode;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * @author BorisMirage
 * Time: 2018/06/12 17:33
 * Created with IntelliJ IDEA
 */

public class RemoveNthFromEnd_19 {
    /**
     * Use two pointers to create a gap that has length of n.
     * In this way, when fast pointer reaches the end, the slow pointer is at n-th from the end of list.
     *
     * @param head head node
     * @param n    n-th node from the end of list to be removed
     * @return modified list
     */

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode cache = new ListNode(0);       // pseudo head
        ListNode slow = cache, fast = cache;
        cache.next = head;

        while (n-- != 0) {
            fast = fast.next;     // create a gap that has length of n
        }

        while (fast.next != null) {        // after the gap is created, move both pointers to the end of list
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;     // when fast reaches the end, slow pointer is at n-th from the end of list
        return cache.next;
    }
}

