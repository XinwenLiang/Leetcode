# 代码随想录算法训练营
## [669. Trim a Binary Search Tree](https://leetcode.com/problems/trim-a-binary-search-tree/description/)

Given the `root` of a binary search tree and the lowest and highest boundaries as `low` and `high`, trim the tree so that all its elements lies in `[low, high]`. Trimming the tree should **not** change the relative structure of the elements that will remain in the tree (i.e., any node's descendant should remain a descendant). It can be proven that there is a **unique answer**.

Return the *root* of the trimmed binary search tree. Note that the root may change depending on the given bounds.

**Example1**

![image](https://github.com/user-attachments/assets/8327d85e-7b46-4f05-8198-3b709ccb506e)


**Input:** root = [3,0,4,null,2,null,null,1], low = 1, high = 3 <br> 
**Output:** [3,2,null,1] 

**Ideas:** <br>
In this example, we need to sever the connections between 3 and 0 as well as between 2 and 0. Node 3 needs to catch the right subtree of node 0 and turn it into the left subtree of node 3.
![image](https://github.com/user-attachments/assets/c55ebe84-aaf9-403c-96af-1b06ae49eb34)

```Java
public class TrimBST {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null) return null;
        if(root.val < low){
            TreeNode right = trimBST(root.right, low, high);
            return right;
        }
        if(root.val > high) {
            TreeNode left = trimBST(root.left, low, high);
            return left;
        }
        root.left = trimBST(root.left, low,high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
```

## [108. Convert Sorted Array to Binary Search Tree](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/)
Given an integer array `nums` where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

**Example1:**

![image](https://github.com/user-attachments/assets/86fb76e4-782e-4ea3-9b8c-8c7e8c91894e)

**Input:** nums = [-10,-3,0,5,9]<br>
**Output:** [0,-3,9,-10,null,5]<br>
**Explanation:** [0,-10,5,null,-3,null,9] is also accepted: <br>
![image](https://github.com/user-attachments/assets/0dd156a7-c6b8-474d-a2c8-03b0f825d576)

**Ideas:**
If the length of the array is odd, simply take the middle element. If it is even, you can take either of the two middle elements (left or right), but you must remain consistent. The 
following code uses a left-closed, right-closed approach to handle the intervals.

```Java
public class ConstructBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = construct(nums, 0, nums.length - 1);
        return root;
    }

    public TreeNode construct(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = construct(nums, left, mid - 1);
        root.right = construct(nums, mid + 1, right);
        return root;
    }
}
```

## [538. Convert BST to Greater Tree](https://leetcode.com/problems/convert-bst-to-greater-tree/description/)
Given the `root` of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus the sum of all keys greater than the 
original key in BST.

As a reminder, a binary search tree is a tree that satisfies these constraints:

* The left subtree of a node contains only nodes with keys **less than** the node's key.
* The right subtree of a node contains only nodes with keys **greater than** the node's key.
* Both the left and right subtrees must also be binary search trees.

**Example1**

![image](https://github.com/user-attachments/assets/ce0886f5-1a3b-4742-8954-cfbc599fa1e7)

**Input:** root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8] <br>
**Output:** [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]

**Ideas:** Since an in-order traversal produces an ascending array, we need a descending order here, so the recursive order is determined to be right-middle-left. The accumulation 
operation naturally leads to the idea of using the two-pointer method. Through experimentation, it was found that using integers as pointers is more convenient than using nodes.

```Java
public class GreaterBST {
    int pre;
    public TreeNode convertBST(TreeNode root) {
        pre = 0;
        traversal(root);
        return root;
    }
    public void traversal(TreeNode cur){
        if(cur == null) return;
        traversal(cur.right);
        cur.val += pre;
        pre = cur.val;
        traversal(cur.left);
    }
}
```









