# 代码随想录算法训练营第三天
## Linked List Fundamentals

**Types**:
* Singly Linked List<br>
 1. A linked list is a linear data structure in which elements are connected by pointers.
 2. Each node consists of two parts: a data field, which stores the actual data, and a pointer field, which stores a pointer to the next node.
 3. The pointer field of the last node points to `null` indicating the end of the list.
 4. The entry point of the linked list is called the head node, referred to as `head`.
 5. The pointer field in a singly linked list can only point to the next node.

![Singly Linked List](https://github.com/user-attachments/assets/824e7e11-51ca-4e3b-9595-41c991a20079)


  

* Doubly Linked List
  Each node has two pointer fields, one pointing to the next node and the other pointing to the previous node.<br>
  And it allows traversal both forward and backward.

  ![Doubly Linked List](https://github.com/user-attachments/assets/464b5c2f-f622-4873-a4be-220f7c84c844)

* Circular Linked List
  Circular linked list is a linked list which is connected end-to-end.

<p align="center">
  <img src="https://github.com/user-attachments/assets/bb57d239-4868-44e0-b383-829d2e6884d7" alt="图片3" width="600">
</p>

  **The storage method of a linked list**

  Since the linked list is linked by the pointers in the pointer fields of each node in memory, the nodes in the linked list are scattered in memory.<br>
  The allocation mechanism depends on the memory management of the operating system.

  **Definition**
  ```Java
  class Node {
    int data; // stored data.
    Node next; // pointer linked with the next node.

    // Constructor.
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
// Define the method of linked list
class LinkedList {
  private Node head; // head node.

  // Constructor and initialize a null linked list.
  public LinkedList() {
    this.head = null;
  }
}
```

## [203. Remove Linked List Elements](https://leetcode.com/problems/remove-linked-list-elements/description/)

Given the `head` of a linked and an integer `var`, remove all the nodes of the linked list that has `Node.val == val`, and return the new 'head'

**Example1**
**Input:** head = [1,2,6,3,4,5,6], val = 6
**Output:** [1,2,3,4,5]

**Idea**
1. Remove nodes directly using the original linked table
2. Introduce 'dummy head' to help.

**Method1** To delete node 6, we simply need to update the pointer pointing to node 6 to point to the next node after node 6.

<img width="959" alt="4105a8d3c1ff67e2c019f0c5c751f79" src="https://github.com/user-attachments/assets/92140dc8-2daf-475f-9024-9b34027e2329">

<img width="723" alt="1c7fcb773bccfa352ad79ec3d8a1cdb" src="https://github.com/user-attachments/assets/c8b4c3bc-11a0-4891-bd43-ad36d5da793f">

```Java
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
```

**Method2** Create a dummy head, and then execute the delete operation like normal linked list.

```Java
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
```

## [707.Design Linked List](https://leetcode.com/problems/design-linked-list/description/)
Design your implementation of the linked list. You can choose to use a singly or doubly linked list.<br>
A node in a singly linked list should have two attributes: `val` and `next`. `val `is the value of the current node, and `next` is a pointer/reference to the next node.<br>
If you want to use the doubly linked list, you will need one more attribute `prev` to indicate the previous node in the linked list. Assume all nodes in the linked list are **0-indexed**.

Implement the `MyLinkedList` class:

* `MyLinkedList()` Initializes the `MyLinkedList` object.
* `int get(int index)` Get the value of the `indexth` node in the linked list. If the index is invalid, return `-1`.
* `void addAtHead(int val)` Add a node of value `val` before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
* `void addAtTail(int val)` Append a node of value `val` as the last element of the linked list.
* `void addAtIndex(int index, int val)` Add a node of value `val` before the `indexth` node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If `index` is greater than the length, the node **will not be inserted**.
* `void deleteAtIndex(int index)` Delete the `indexth` node in the linked list, if the index is valid.

**Idea**: Create a new dummy head.

```Java
// Singly Linked List
class MyLinkedList {
    int size;
    ListNode head;

    public MyLinkedList() {
        this.head = new ListNode(0); // Create a dummy head.
        this.size = 0;
    }
// Search for the index-th element.
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode cur = head;
        for (int i = 0; i <= index; i++) { 
            cur = cur.next;
        }
        return cur.val;
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
        ListNode cur = head;
        ListNode newNode = new ListNode(val);
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = newNode;
        size++;
    }
// Insert a new node at the index-th node.
    public void addAtIndex(int index, int val) {
        if (index < 0) {
            index = 0;
        }
        if (index > size) {
            return;
        }
        ListNode newNode = new ListNode(val);
        ListNode prev = head;
// Find the predecessor of the node to be inserted.
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        newNode.next = prev.next;
        prev.next = newNode;
        size++;
    }
// Delete the index-th node.
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        ListNode prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = prev.next.next;
        size--;
    }
}
```

```Java
// Doubly Linked List.
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
```
## [206. Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/description/)
Given the `head` of a singly linked list, reverse the list, and return the reversed list.

**Example1**
![image](https://github.com/user-attachments/assets/7f34ac7d-4912-4cb0-93fd-eade10538dee)
**Input**: head = [1,2,3,4,5]
**Output**: [5,4,3,2,1]

**Idea**
1. Two pointer `cur` and `prev`.
2. Recursion

**Two Pointer Method**
```Java
public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
    return prev;
    }
```

**Recursion**
```Java
public ListNode reverseList(ListNode head) {
        return reverse(head, null);
    }

    public ListNode reverse(ListNode cur, ListNode prev) {
        if (cur == null) {
            return prev;
        }
        ListNode temp = cur.next;
        cur.next = prev;
        return reverse(temp, cur);
    }
```

## Sweet are the uses of adversity.

<p align="center">
  <img src="https://github.com/user-attachments/assets/b225e1a8-552f-479a-86b5-a5c6835c52c9" alt="图片3" width="600">
</p>








