package Day3;

public class RemoveElement {
    public ListNode removeElement(ListNode head, int val) {
        // If head is equal to the value, change the head to the next.
        while (head != null && head.val == val) {
            head = head.next;
        }
        // Create a new pointer variable used for iterating the linked list from a new head.
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            }
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
