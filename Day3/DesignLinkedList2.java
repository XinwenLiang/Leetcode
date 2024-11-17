package Day3;

public class DesignLinkedList2 {
    int size;
    ListNode head, tail;

  public DesignLinkedList2(){
      this.size = 0;
      this.head = new ListNode(0); // dummy new head.
      this.tail = new ListNode(0);// dummy new tail.
      head.next = tail;
      tail.prev = head;
  }

  public int get(int index){
      // If index is invalid.
      if(index<0 || index >= size){
          return -1;
      }
      ListNode cur = this.head;

      // Determine the less time cost on iterating.
      if (index > size/2){
          // Begin from the tail.
          cur = tail;
          for (int i = 0; i <= size - index; i++) {
              cur = cur.prev;
          }
      }else{
          cur = head;
          for (int i = 0; i < index; i++) {
              cur = cur.next;
          }
      }
      return cur.val;
  }

  public void addAtHead(int val){
      addAtIndex(0, val);
  }

  public void addAtTail(int val){
      addAtIndex(size, val);
  }

  public void addAtIndex(int index, int val){
      if (index < 0 || index > size){
          return;
      }
      ListNode prev = this.head;
      for (int i = 0; i < index; i++) {
          prev = prev.next;
      }
      ListNode newNode = new ListNode(val);
      newNode.next = prev.next;
      newNode.prev = prev;
      if (prev.next != null) {
          prev.next.prev = newNode;
      }
      prev.next = newNode;
      size++;
  }

  public void deleteAtIndex(int index){
      if (index < 0 || index >= size){
          return;
      }
      ListNode prev = this.head;
      for (int i = 0; i < index; i++) {
          prev = prev.next;
      }
      prev.next.next.prev = prev;
      prev.next = prev.next.next;
      size--;
  }
}
