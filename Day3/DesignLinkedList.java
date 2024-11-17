package Day3;

public class DesignLinkedList {
    int size;
    ListNode head;

    // Initialize the linked list
    public void SingleLinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    // Search for the index-th element.
    public int get(int index) {
        // If index is illegal, return -1.
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode currentNode = head;
        for (int i = 0; i <= index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.val;
    }

    // Add a new node before the head. Notice the order.
    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head.next;
        head.next = newNode;
        size++;
    }

    // Add a new node after the tail.
    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = newNode;
        size++;
    }

    // Insert a new node at the index-th node.
    public void addAtIndex(int index, int val) {
      if(index > size){
          return;
        }
      if (index <0){
          index = 0;
      }
      size++;
      // Find the predecessor of the node to be inserted
        ListNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        ListNode AddNode = new ListNode(val);
        AddNode.next = pred.next;
        pred.next = AddNode;
    }

    // Delete the index-th node.
    public void deleteAtIndex(int index){
        if (index < 0 || index > size){
            return;
        }
        // Here the head is the dummy head.
        ListNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        pred.next = pred.next.next;
        size--;
    }
}


