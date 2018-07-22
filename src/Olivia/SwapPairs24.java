package Olivia;

public class SwapPairs24 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode swapPairs(ListNode head) {
        //special case for head has zero or one element
        if(head==null||head.next==null)
            return head;
        ListNode head1 = head.next;
        ListNode p = head;
        ListNode q = head.next;
        //using tmp to link the swap two
        ListNode tmp = null;
        while(p!=null&&q!=null){
           p.next = q.next;
           q.next = p;
           if(tmp!=null){
               tmp.next=q;
           }
           if(p.next==null)
               break;
           q = p.next.next;
           tmp = p;
           p = p.next;
        }
        return head1;
    }
}
