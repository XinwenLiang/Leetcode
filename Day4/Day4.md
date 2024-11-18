# 代码随想录算法训练营第四天
## [24. Swap Nodes in Pairs](https://leetcode.com/problems/swap-nodes-in-pairs/description/)

Given a linked list, swap every two adjacent nodes and return its head. 
You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

**Example1:**
**Input:** head = [1,2,3,4] <br>
**Output:** [2,1,4,3]

<p align="center">
  <img src="https://github.com/user-attachments/assets/8e4ba9d2-6481-47f0-8edb-5506bc598c75" alt="Problem1" width="600">
</p>

**Idea:**
1. Use the pointer to help.
2. Use recursion to optimize the algorithm.
We need to notice the condition of loop as well as the order of swapping. If the number of nodes is odd, then we set `cur.next.next != null` as the loop condition.
If the number of nodes is even, then we set `cur.next = null`. The order is showed in the following picture.
![image](https://github.com/user-attachments/assets/398c2884-25b2-41d1-9541-58a7291a545b)

Method1: Use the pointer (I chose to swap the first node and second node directly, avoid creating two temporatory variables)
```Java
public class SwapPairs {
   public ListNode swapPairs(ListNode head){
       ListNode dummyHead = new ListNode(0);
       dummyHead.next = head;
       ListNode cur = dummyHead;
       while(cur.next != null && cur.next.next != null){
          ListNode firstNode = cur.next;
          ListNode secondNode = cur.next.next;
          firstNode.next = secondNode.next;
          secondNode.next = firstNode;
          cur.next = secondNode;

          // Move to another pair.
           cur = firstNode;
       }
       return dummyHead.next;
   }
}
```
Method2: Recursion.
```Java
public class SwapPairsRe {
    public ListNode swapPairs(ListNode head) {
// If the linked list is null or it only contains one element, return head itself.
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode newNode = swapPairs(next.next); // Recursion step.
// Swap the pairs.
        next.next = head;
        head.next = newNode;
        return next;
    }
}
```
## [19.Remove Nth Node from End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/)

Given the `head` of a linked list, remove the `nth` node from the end of the list and return its `head`.

**Example1**

<p align="center">
  <img src="https://github.com/user-attachments/assets/ceb34f7b-e548-4d58-b9af-d47bfc9c029d" alt="Example1" width="600">
</p>

**Input:** head = [1,2,3,4,5]; n = 2 <br>
**OutPut:** [1,2,3,5]

**Idea:** Use two pointers method. Step1: Let both fast pointer and slow pointer point to dummyhead.

<p align="center">
  <img src="https://github.com/user-attachments/assets/42d2b070-ecb8-483d-9d50-3355f533c36f" alt="Example1" width="600">
</p>

Step2: Move the fast pointer to n+1 steps

<p align="center">
  <img src="https://github.com/user-attachments/assets/e4249abe-9bca-4b11-836b-8133e7b4353b" alt="Example1" width="600">
</p>


Step3: Move both the fast and slow pointers until fast pointer point to null.

<p align="center">
  <img src="https://github.com/user-attachments/assets/c8f8946f-ff66-49bb-a2ac-ec99a5d0d43b" alt="Example1" width="600">
</p>


```Java
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
```

 




















































