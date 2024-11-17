package Day4;

import Day3.ListNode;

public class SwapPairs {
   public ListNode swapPairs(ListNode head){
       ListNode dummyHead = new ListNode(0);
       dummyHead.next = head;
       ListNode cur = dummyHead;
       while(cur.next != null && cur.next.next != null){
          ListNode firstNode = cur.next;
          ListNode secondNode = cur.next.next;
          firstNode.next = secondNode.next;
          secondNode.next = firstNode;
          cur.next = secondNode;

          // Move to another pair.
           cur = firstNode;
       }
       return dummyHead.next;
   }
}
