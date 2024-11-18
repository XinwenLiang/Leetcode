package Day4;

import Day3.ListNode;

public class SwapPairsRe {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode newNode = swapPairs(next.next); // Recursion step.
        next.next = head;
        head.next = newNode;
        return next;
    }
}
