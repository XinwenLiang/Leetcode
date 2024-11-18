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





















































