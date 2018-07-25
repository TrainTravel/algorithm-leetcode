package Olivia;



public class ReverseKGroup25 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode reverseKGroup(ListNode head, int k) {
            //special case for head has zero or one  element
        if(k<2||head==null||head.next==null)
            return head;
        ListNode cur = head;
        int count = 0;
        while(cur!=null&&count<k){
            cur = cur.next;
            count++;
        }
        if(count==k){
            cur = reverseKGroup(cur,k);
            while(count>0){
               ListNode tmp = head.next;
               head.next = cur;
               cur = head;
               head = tmp;
               count--;
            }
            head = cur;
        }
        return head;
}}
