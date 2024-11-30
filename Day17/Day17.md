# 代码随想录算法训练营第十七天
## [654. Maximum Binary Tree](https://leetcode.com/problems/maximum-binary-tree/description/)
You are given an integer array `nums` with no duplicates. A **maximum binary tree** can be built recursively from `nums` using the following algorithm:

1. Create a root node whose value is the maximum value in `nums`.
2. Recursively build the left subtree on the **subarray prefix** to the **left** of the maximum value.
3. Recursively build the right subtree on the **subarray suffix** to the **right** of the maximum value.
4. Return the **maximum binary tree** built from `nums`.

**Example1:**

![image](https://github.com/user-attachments/assets/b1002533-f237-49f0-b3ec-ba0d43df7947)

**Input:** nums = [3,2,1,6,0,5] <br>
**Output:** [6,3,5,null,2,0,null,null,1]<br>
**Explanation:** The recursive calls are as follow:
- The largest value in [3,2,1,6,0,5] is 6. Left prefix is [3,2,1] and right suffix is [0,5].
    - The largest value in [3,2,1] is 3. Left prefix is [] and right suffix is [2,1].
        - Empty array, so no child.
        - The largest value in [2,1] is 2. Left prefix is [] and right suffix is [1].
            - Empty array, so no child.
            - Only one element, so child is a node with value 1.
    - The largest value in [0,5] is 5. Left prefix is [0] and right suffix is [].
        - Only one element, so child is a node with value 0.
        - Empty array, so no child.

**Ideas:** The task is to construct the maximum binary tree, where the maximum element serves as the root node, the left interval becomes the left subtree,
and the right interval becomes the right subtree. First, we need to find the root node and then recursively construct the left and right subtrees starting 
from the root node. Therefore, we need to use a preorder traversal. In this problem, we will continue using a recursive approach to handle it.

```Java
public class ConstructMaximumTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length);
    }
    public TreeNode construct(int[] nums, int leftIndex, int rightIndex){
        if(rightIndex - leftIndex < 1){
            return null;
        }
        if(rightIndex - leftIndex == 1){
            return new TreeNode(nums[leftIndex]);
        }
        int index = leftIndex;
        int maxVal = nums[leftIndex];
        for (int i = leftIndex + 1; i < rightIndex; i++) {
            if(nums[i] > maxVal){
                maxVal = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(maxVal);
        root.left = construct(nums, leftIndex, index); // Left-closed, right-open interval
        root.right = construct(nums, index+1, rightIndex); //Left-closed, right-open interval
        return root;
    }
}
```

## [617. Merge Two Binary Trees](https://leetcode.com/problems/merge-two-binary-trees/description/)
You are given two binary trees `root1` and `root2`.

Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.

Return the merged tree.

**Note:** The merging process must start from the root nodes of both trees.

**Example1** 

![image](https://github.com/user-attachments/assets/acf1f594-c51c-4586-a4b3-a463f01777ef)

**Input:** root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7] <br>
**Output:** [3,4,5,5,4,null,7] 

**Ideas:** This problem involves handling two binary trees. We can approach it in two ways: 
one is to modify the original binary tree, and the other is to define a new binary tree. 
The traversal order can be pre-order, in-order, or post-order.

```Java
public class MergeTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null) return root2;
        if(root2 == null) return root1;
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);// Based on Tree1, merge two binary trees.
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }
}
```

## [700 Search in a Binary Search Tree](https://leetcode.com/problems/search-in-a-binary-search-tree/description/)
You are given the `root` of a binary search tree (BST) and an integer `val`.

Find the node in the BST that the node's value equals `val` and return the subtree rooted with that node. If such a node does not exist, return `null`.

**Example1**

![image](https://github.com/user-attachments/assets/52ba0b8d-8e74-45a0-8962-98f45c28aee3)

**Input:** root = [4,2,7,1,3], val = 2 <br>
**Output:** [2,1,3]

**Ideas:**
This problem can leverage the properties of a binary search tree to traverse the tree until the node corresponding to the target value is found. 
Both iterative and recursive approaches are relatively straightforward for this task.

```Java
public class SearchBst {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null || root.val == val){
            return root;
        }
        if(val < root.val){
            return searchBST(root.left, val);
        }else{
            return searchBST(root.right, val);
        }
    }
}
```

## [98. Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/description/)

Given the `root` of a binary tree, determine if it is a valid binary search tree (BST).

A **valid BST** is defined as follows:

* The left subtree of a node contains only nodes with keys **less than** the node's key.
* The right subtree of a node contains only nodes with keys **greater than** the node's key.
* Both the left and right subtrees must also be binary search trees.

**Example1:**

![image](https://github.com/user-attachments/assets/a2fceba1-b179-4b44-be15-646c9229beb9)

**Input:** root = [2,1,3] <br>
**Output:** true

**Ideas:**
* Approach 1: Perform an in-order traversal of the entire binary tree, storing each node in an array. Since an in-order traversal of a binary search tree (BST) produces a sorted array, we only need to check whether the array is sorted.
* Approach 2: Use a recursive method by defining a global variable and traversing the tree in in-order.
* Approach 3 (Optimal Solution): Use the two-pointer method, with one pointer tracking the previous node (pre). Simply compare the current node with the previous node to determine the validity.

```Java
public class ValidateBinarySearchTree {
    TreeNode max;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isValidBST(root.left);
        if (!left) {
            return false;
        }
        if (max != null && root.val < max.val) {
            return false;
        }
        max = root;
        boolean right = isValidBST(root.right);
        return right;
    }
}
```













