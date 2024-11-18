package Day4;

import Day3.ListNode;

public class IntersectNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null; // If either list is null, no intersection is possible.
        }

        // Calculate the lengths of both lists.
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0, lenB = 0;

        while (curA != null) {
            curA = curA.next;
            lenA++;
        }

        while (curB != null) {
            curB = curB.next;
            lenB++;
        }

        // Reset pointers to the head of each list.
        curA = headA;
        curB = headB;

        // Move the pointer of the longer list ahead by the difference in lengths.
        int diff = Math.abs(lenA - lenB);
        if (lenA > lenB) {
            while (diff-- > 0) {
                curA = curA.next;
            }
        } else {
            while (diff-- > 0) {
                curB = curB.next;
            }
        }

        // Iterate both lists together until an intersection is found or end is reached.
        while (curA != null && curB != null) {
            if (curA == curB) {
                return curA; // Intersection node found.
            }
            curA = curA.next;
            curB = curB.next;
        }

        return null; // No intersection.
    }
}
