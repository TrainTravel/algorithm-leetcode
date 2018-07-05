package Mirage.LeetCodeSolution;

/**
 * @author BorisMirage
 * Time: 2018/06/18 21:09
 * Created with IntelliJ IDEA
 */

public class ReverseKGroup {
    /**
     * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
     * k is a positive integer and is less than or equal to the length of the linked list.
     * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
     *
     * @param head head ListNode
     * @param k
     * @return ListNode that is reversed
     */
    public ListNode reverseKGroup(ListNode head, int k) {

        /* Special Case */
        if (k <= 1 || head == null) {
            return head;
        }

        ListNode current = head;
        int count = 0;

        /* Find current reverse part */
        while (current != null && count != k) {
            current = current.next;
            count++;
        }

        /* If current part is not remaining part of linked list */
        if (count == k) {

            /* In each recursion, the return value is next recursion's start ListNode */
            current = reverseKGroup(current, k);

            /* Reverse example:
             * 1 -> 2 -> 3 -> 4 -> 5 ->
             * <- 1 <- 2 <- 3 <- 4 <- 5
             * 5 -> 4 -> 3 -> 2 -> 1 -> */
            while (count > 0) {

                /* Set a cache to store next node that will be relinked */
                ListNode cache = head.next;

                /* Link origin next pointer to previous node for reverse */
                head.next = current;
                current = head;

                /* Set next reverse node */
                head = cache;

                count--;
            }
            head = current;
        }

        /* Result and recursion return value */
        return head;
    }
}
