package Day3;

public class RemoveElement {
    // Method1: Remove nodes directly using the original linked table
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

    // Method2: Create a dummy head.
    public ListNode remove(ListNode head, int val){
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode cur = dummy;
        while(cur.next != null){
            if(cur.next.val == val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}


class ListNode {
    int val;
    ListNode next, prev;
    ListNode(){}

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
