package Lib.ListNode;

/**
 * Generate a linked list.
 *
 * @author BorisMirage
 * Time: 2020/02/26 19:03
 * Created with IntelliJ IDEA
 */

public class LinkedListGenerator {
    /**
     * Generate linked list by integer array.
     *
     * @param arr given linked list
     * @return head node of linked list
     */
    public static ListNode generate(int[] arr) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        for (int n : arr) {
            current.next = new ListNode(n);
            current = current.next;
        }

        return dummy.next;
    }

    /**
     * Print all values in linked list.
     *
     * @param head head of given linked list
     */
    public static void printAll(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        ListNode tmp = generate(arr);
        printAll(tmp);
    }
}
