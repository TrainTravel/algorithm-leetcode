package Solution.List;

import Lib.ListNode;

/**
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 * Example:
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 *
 * @author BorisMirage
 * Time: 2018/08/05 14:37
 * Created with IntelliJ IDEA
 */

public class RotateRight_61 {
    /**
     * Find i - k % ith node and do the rotation.
     *
     * @param head head ListNode
     * @param k    k times rotation
     * @return new head ListNode
     */
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null) {
            return head;
        }

        int i = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode a = dummy;
        ListNode b = dummy;

        /* Count total length */
        while (a.next != null) {
            i++;
            a = a.next;
        }

        /* Get i - k % i node for quicker rotation */
        for (int j = i - k % i; j > 0; j--) {
            b = b.next;
        }

        a.next = dummy.next;
        dummy.next = b.next;
        b.next = null;

        return dummy.next;
    }
}
