package Day4;

import Day3.ListNode;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;
        // Step2； Move the fast pointer to n+1.
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        //Step3: Move both pointers.
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        //Remove the element
        if (slow.next != null) {
            slow.next = slow.next.next;
        }
        return dummyHead.next;
    }
}
