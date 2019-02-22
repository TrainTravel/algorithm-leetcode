package Solution.List;

import Lib.ListNode;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers.
 * Leaving only distinct numbers from the original list.
 * <p>
 * Example 1:
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * Example 2:
 * Input: 1->1->1->2->3
 * Output: 2->3
 *
 * @author BorisMirage
 * Time: 2018/08/16 14:03
 * Created with IntelliJ IDEA
 */

public class DeleteDuplicatesII_82 {
    /**
     * Two pointers.
     * One point to previous non-duplicate element, the other one point to next non-duplicate element.
     *
     * @param head first ListNode
     * @return removed list head node
     */
    public ListNode deleteDuplicatesII(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        /* Two comparing ListNode */
        ListNode a = dummy;
        ListNode b = head;

        while (b != null) {

            /* If next element is duplicated, remove it */
            while (b.next != null && b.val == b.next.val) {

                /* "remove" */
                b = b.next;
            }

            /* If a & b (assumed as 2 connected elements) are same, remove previous one */
            if (a.next == b) {
                a = a.next;
            } else {

                /* Link two non-duplicate elements */
                a.next = b.next;
            }

            /* Move to next element */
            b = b.next;
        }
        return dummy.next;
    }
}
