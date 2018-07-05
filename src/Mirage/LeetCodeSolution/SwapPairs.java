package Mirage.LeetCodeSolution;


/**
 * @author BorisMirage
 * Time: 6/13/18 15:56
 * Created with IntelliJ IDEA
 */

public class SwapPairs {
    /**
     * Given a linked list, swap every two adjacent nodes and return its head.
     * <p>
     * Note:
     * Your algorithm should use only CONSTANT extra space.
     * You may not modify the values in the list's nodes, only nodes itself may be changed.
     * <p>
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     *
     * @param head first node
     * @return ListNodes with correct order
     */
    public ListNode swapPairs(ListNode head) {

        /* Special Case */
        if (head == null || head.next == null) {
            return head;
        }

        /* Work as init ListNode */
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        /* First ListNode is dummy rather than head */
        ListNode cur = dummy;

        while (cur.next != null && cur.next.next != null) {

            /* Store current ListNode's next two node */
            ListNode cache = cur.next.next;

            /* Replace current ListNode's next two node's next pointer to current ListNode's next pointer */
            cur.next.next = cache.next;

            /* Replace cache ListNode's next pointer to currnent's next pointer */
            cache.next = cur.next;

            /* Link next round's current ListNode */
            cur.next = cache;

            /* Switch current ListNode's position */
            cur = cache.next;
        }
        return dummy.next;
    }
}
/* List node sample */
// 5->4->3->2->1
//    public ListNode getList3() {
//        ListNode n1 = new ListNode(5);
//        ListNode n2 = new ListNode(4);
//        ListNode n3 = new ListNode(3);
//        ListNode n4 = new ListNode(2);
//        ListNode n5 = new ListNode(1);
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
//        ListNode head = n1;
//        return head;
//    }