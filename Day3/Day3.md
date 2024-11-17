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










