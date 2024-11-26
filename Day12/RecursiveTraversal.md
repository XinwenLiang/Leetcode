# Recursive Traversal of a Binary Tree

## Three-Step Approach to Recursion:

1. Define the Parameters and Return Value of the Recursive Function<br>
Determine which parameters need to be handled during the recursion process. Include these parameters in the recursive function.
Additionally, clarify the return value of the recursive function for each call to determine the return type of the function.

2. Establish the Termination Condition<br>
After writing the recursive algorithm, it's common to encounter stack overflow errors during execution. 
This happens when the termination condition is either missing or incorrectly written. The operating system uses a stack structure to store the information for each layer of recursion. If recursion doesn’t terminate, the memory stack of the operating system will inevitably overflow.

3. Define the Logic for a Single Layer of Recursion<br>
Determine the information that needs to be processed at each layer of recursion. At this step, the recursive function will be repeatedly called within itself to implement the recursion process.

## [144. Binary Tree Preorder Traversal](https://leetcode.com/problems/binary-tree-preorder-traversal/description/)

Given the `root` of a binary tree, return the preorder traversal of its nodes' values.

**Example 1:**

**Input:** root = [1,null,2,3]

**Output:** [1,2,3]

**Explanation:**

![image](https://github.com/user-attachments/assets/fab128f1-a2fc-419f-ac35-3d9df0167eaa)


