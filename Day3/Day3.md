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

  ![Circular Linked List](https://github.com/user-attachments/assets/bb57d239-4868-44e0-b383-829d2e6884d7)

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

## [203. Remove Linked List Elements](https://leetcode.com/problems/remove-linked-list-elements/description/)

Given the `head` of a linked and an integer `var`, remove all the nodes of the linked list that has `Node.val == val`, and return the new 'head'

**Example1**








