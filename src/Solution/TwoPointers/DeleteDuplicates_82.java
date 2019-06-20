package Solution.TwoPointers;

import Lib.ListNode;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers.
 * Leaving only distinct numbers from the original list.
 *
 * @author BorisMirage
 * Time: 2018/08/16 14:03
 * Created with IntelliJ IDEA
 */

public class DeleteDuplicates_82 {
    /**
     * Two pointers.
     * One point to previous non-duplicate element, the other one point to next non-duplicate element.
     *
     * @param head first ListNode
     * @return removed list head node
     */
    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(0);       // cache node
        dummy.next = head;

        ListNode slow = dummy, fast = head;     // two pointers

        while (fast != null) {
            while (fast.next != null && fast.val == fast.next.val) {     // move pass all duplicated nodes
                fast = fast.next;
            }

            if (slow.next == fast) {        // no duplicated node found
                slow = slow.next;
            } else {
                slow.next = fast.next;      // move previous non-duplicated value to next non-duplicated value
            }
            fast = fast.next;
        }

        return dummy.next;      // return head of list
    }
}
