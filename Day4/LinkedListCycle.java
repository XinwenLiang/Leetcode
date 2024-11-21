package Day4;

import Day3.ListNode;

import java.util.List;

public class LinkedListCycle {
    public ListNode detectCycle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){// Because fast moves two paces in each step.
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){ // If they can meet, it means the linked list has a cycle.
               ListNode index1 = fast;
               ListNode index2 = head;
               while(index1 != index2){
                   index1 = index1.next;
                   index2 = index2.next;
               }
               return index1;
            }
        }

        return null;
    }
}
