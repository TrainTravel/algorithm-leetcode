package Playground;

import Lib.ListNode.ListNode;

/**
 * @author BorisMirage
 * Time: 2019/10/11 13:15
 * Created with IntelliJ IDEA
 */

public class LinkedListGenerator {
    public static ListNode generatorByRange(int start, int end) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        for (int i = start; i <= end; i++) {
            current.next = new ListNode(i);
            current = current.next;
        }

        return dummy.next;
    }

    public static ListNode generatorByArray(int[] arr) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        for (int i : arr) {
            current.next = new ListNode(i);
            current = current.next;
        }

        return dummy.next;
    }
}
