package Solution.ListNode;

import Lib.ListNode;

/**
 * Reverse a linked list from position m to n in one-pass.
 *
 * @author BorisMirage
 * Time: 2019/06/29 13:58
 * Created with IntelliJ IDEA
 */

public class ReverseBetween_92 {
    /**
     * Reverse a list in certain range. This is same as reverse list in k group.
     * Traverse list to start dummy head, and reverse list until reaches the end.
     *
     * @param head head node
     * @param m    start at mth (index m - 1)
     * @param n    end at nth (end index n - 1)
     * @return reversed list
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {

        /* Corner case */
        if (head == null || n == m) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode begin = dummy;
        for (int i = 0; i < m - 1; i++) {
            begin = begin.next;
        }

        ListNode current = begin.next;
        ListNode next, first = current;
        ListNode previous = current;
        while (m < n + 1) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            m++;
        }

        begin.next = previous;
        first.next = current;

        return dummy.next;
    }

    public static void main(String[] args) {
        ReverseBetween_92 test = new ReverseBetween_92();
        printAll(test.reverseBetween(getList3(), 3, 4));
    }

    private static ListNode getList3() {
        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        return n1;
    }

    private static void printAll(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
