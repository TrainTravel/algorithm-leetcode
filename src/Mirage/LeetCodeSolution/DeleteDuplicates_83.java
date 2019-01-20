package Mirage.LeetCodeSolution;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * Example 1:
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 *
 * @author BorisMirage
 * Time: 2018/08/16 14:20
 * Created with IntelliJ IDEA
 */

public class DeleteDuplicates_83 {
    /**
     * Simply remove duplicates elements.
     *
     * @param head head ListNode
     * @return removed head ListNode
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while (node != null && node.next != null) {
            if (node.val == node.next.val) {

                /* Move duplicate element to next */
                node.next = node.next.next;
            } else {

                /* Link non-repetitive element */
                node = node.next;
            }
        }
        return head;
    }
}
