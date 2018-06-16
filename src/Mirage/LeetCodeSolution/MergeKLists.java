package Mirage.LeetCodeSolution;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 6/13/18
 * Time: 12:48
 */

public class MergeKLists {
    /**
     * Merge k sorted linked lists and return it as one sorted list.
     * Analyze and describe its complexity.
     * <p>
     * Use divide and conquer to merge each two lists and recursively complete this process until only one list left.
     *
     * <p>
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     *
     * @param lists input LitNode Array
     * @return next ListNode
     */
    public ListNode mergeKLists(ListNode[] lists) {

        /* Special case */
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        return divide(lists, 0, lists.length - 1);
    }


    /**
     * Divide input lists from mid and put into two subpart recursively, until each subpart only has one element.
     * Then merge these two lists using mergeTwoLists method.
     * Finally, the whole ListNode list will be merged and this merged list will be returned.
     *
     * @param list  input list
     * @param start strat index
     * @param end   end index
     * @return merged result
     */
    public ListNode divide(ListNode[] list, int start, int end) {
        if (start == end) {
            return list[start];
        }
        if (start < end) {
            int mid = (end + start) / 2;
            ListNode l1 = divide(list, start, mid);
            ListNode l2 = divide(list, mid + 1, end);
            return mergeTwoLists(l1, l2);
        } else {
            return null;
        }
    }

    /**
     * Merge two sorted linked lists and return it as a new list.
     * The new list should be made by splicing together the nodes of the first two lists.
     * <p>
     * Simply compare value in two ListNode. Point smaller one as next node.
     * <p>
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
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
