package Mirage.LeetCodeSolution;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 6/12/18
 * Time: 17:33
 */

public class RemoveNthFromEnd {
    /**
     * Given a linked list, remove the n-th node from the end of list and return its head.
     * <p>
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cache = new ListNode(0);
        ListNode back = cache, front = cache;
        cache.next = head;

        /* When nth node is not reached, move to next node */
        while (n-- != 0) {
            front = front.next;
        }

        /* Start from nth node, link next node to previous node in order to remove nth node */
        while (front.next != null) {
            front = front.next;
            back = back.next;
        }
        back.next = back.next.next;
        return cache.next;
    }
}

