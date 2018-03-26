package LeetCodeSolution;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 11/24/17
 * Time: 12:26
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */


//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//        Output: 7 -> 0 -> 8
//        Explanation: 342 + 465 = 807.


/* Sum two nodes and return the sum node. Until List is empty */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(0);
        ListNode current = result;

        int nodeValue1;
        int nodeValue2;
        int sum;
        int carry = 0;

        while (l1 != null || l2 != null) {

            /* Find value in node */
            if (l1 != null) {
                nodeValue1 = l1.val;
            } else {
                nodeValue1 = 0;
            }
            if (l2 != null) {
                nodeValue2 = l2.val;
            } else {
                nodeValue2 = 0;
            }

            /* Sum them and check carry */
            sum = carry + nodeValue1 + nodeValue2;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }
        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return result.next;
    }

    public static void main(String[] args) {
    }
}


/**
 * ListNode contains one single value.
 * This class has "link" function, which is "next".
 * <p>
 * However, it DO NOT SAVE node, just virtually "link" current node to next node.
 * That is to say, it only "link" CURRENT status to NEXT status, and it is also a ListNode.
 */
class ListNode {

    /* value of current node */
    int val;

    /* Next linked node */
    ListNode next;

    /**
     * @param x value that related to this current ListNode
     */
    ListNode(int x) {
        val = x;
    }
}