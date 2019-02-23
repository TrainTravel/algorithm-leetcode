package Solution.List;

import Lib.ListNode;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 * @author BorisMirage
 * Time: 2018/06/12 19:03
 * Created with IntelliJ IDEA
 */

public class MergeTwoSortedLists_21 {

    /**
     * Simply compare value in two ListNode. Point smaller one as next node.
     *
     * @param l1 first node
     * @param l2 second node
     * @return next smaller node
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
