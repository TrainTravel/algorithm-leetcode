package Olivia;


public class RotateRight61 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public ListNode rotateRight(ListNode head, int k) {

            /* special case for k=0 */
            if (k == 0) {
                return head;
            }

            /* special case for head has zero or one element */
            if (head == null || head.next == null) {
                return head;
            }

            ListNode result = new ListNode(0);
            ListNode p = head;
            ListNode q = head;
            int count = 0;
            int move;

            /* count the length of the list */
            while (p.next != null) {
                p = p.next;
                count++;
            }
            count++;

            /* count steps to move */
            if (k < count) {
                move = count - k;
            } else {
                move = count - k % (count);
            }

            /* move the list */
            if (k % count == 0) {
                return head;
            }
            p.next = head;
            move--;
            while (move != 0) {
                q = q.next;
                move--;
            }
            result.next = q.next;
            q.next = null;
            return result.next;
        }
    }
}
