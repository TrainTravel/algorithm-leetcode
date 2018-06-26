package Olivia;

/**
 * Created with IntelliJ IDEA
 * Author: Olivia
 * Date: 6/17/18
 * Time:
 */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre  = new ListNode (0);
        ListNode nextOne = pre;
        int carry = 0;
        while(l1!=null || l2!=null||carry!=0)
        {
            ListNode cur = new ListNode(0);
            int sum = 0;
            if(l1==null&&l2==null)
            {
                sum = carry;
            }
            if (l1 == null)
            {
                sum  = carry + l2.val;
            }
            if (l2 == null)
            {
                sum = carry + l1.val;
            }
            else
            {
                sum = carry + l1.val +l2.val;
            }
            if (sum > 10)
            {
                sum = sum - 10;
                carry = 1;
            }
            else
            {
                carry = 0;
            }
            cur.val = sum;
            pre.next = cur;
            pre = pre.next;
            if (l1 != null)
            {
                l1 = l1.next;
            }
            if (l2 != null)
            {
                l2 = l2.next;
            }
        }
        return nextOne.next;
    }
}