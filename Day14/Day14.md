# 代码随想录算法训练营第14天
## [226. Invert Binary Tree](https://leetcode.com/problems/invert-binary-tree/description/)
Given the `root` of a binary tree, invert the tree, and return its root.

**Example1:**

![image](https://github.com/user-attachments/assets/3358ca18-6827-4966-af16-8eb91d47d00a)

**Input:** root = [4,2,7,1,3,6,9] <br>
**Output:** [4,7,2,9,6,3,1]

**Ideas:** The task is to swap the left and right children of the nodes. Note that it is the pointers being swapped, not the values. The code logic for this task is relatively straightforward and clear when using either preorder or postorder traversal.

```Java
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        // Postorder traversal method.
        if(root == null) return null;
        invertTree(root.left);
        invertTree(root.right);
        swapChildren(root);
        return root;
    }
    public void swapChildren(TreeNode node){
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}
```

## [101. Symmetric Tree](https://leetcode.com/problems/symmetric-tree/description/)
Given the `root` of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

**Example1:**

![image](https://github.com/user-attachments/assets/64bfa625-e8fb-407c-aeb2-3263e3e99dca)

**Input:** root = [1,2,2,3,4,4,3]<br>
**Output:** true

**Ideas:** This problem is essentially about determining whether the left and right subtrees can be reversed to become each other. The traversal order must use postorder traversal. During the comparison, nodes on the same "inner side" are compared with each other, and nodes on the same "outer side" are compared with each other.

```Java
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return compare(root.left, root.right);
    }

    public boolean compare(TreeNode left, TreeNode right){
        if(left == null && right != null){
            return false;
        }else if(left != null && right == null){
            return  false;
        }else if(left == null && right == null){
            return true;
        }else if(left.val != right.val){
            return false;
        }
        // Compare the outside.
        boolean outside = compare(left.left, right.right);
        boolean inside = compare(left.right, right.left);
        return outside && inside;
    }
}
```

## [104. Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/description/)
Given the `root` of a binary tree, return its maximum depth.

A binary tree's **maximum depth** is the number of nodes along the longest path from the root node down to the farthest leaf node.

**Example1**

![image](https://github.com/user-attachments/assets/15e24f71-77e2-4c8b-8d9d-b70c1fcd8fcf)

**Input:** root = [3,9,20,null,null,15,7]<br>
**Output:** 3

**Ideas:** In this problem, we can use a recursive traversal method. To calculate the height of a binary tree, we use postorder traversal, while for calculating the depth, we use preorder traversal. This problem requires finding the maximum depth of the binary tree, which is equivalent to finding its maximum height. Therefore, we use postorder traversal. Of course, preorder traversal is also an option, but during my first attempt, I chose postorder traversal.

```Java
public class MaximumDepth {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        int height = 1+ Math.max(leftHeight, rightHeight);
        return height;
    }
}
```
## [111. Minimum Depth of Binary Tree](https://leetcode.com/problems/minimum-depth-of-binary-tree/description/)
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

**Note:** A leaf is a node with no children.

**Example1**

![image](https://github.com/user-attachments/assets/f8129056-f80e-46d3-86e2-f7308e395e07)

**Input:** root = [3,9,20,null,null,15,7]<br>
**Output:** 2

**Ideas:** This problem is related to finding the minimum depth of a binary tree but is not entirely the same. During my first attempt, I chose to use postorder traversal for recursive processing.

```Java
public class MinimumDepth {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = minDepth(root.left);
        int rightHeight = minDepth(root.right);
        if (root.left == null && root.right != null) {
            return 1 + rightHeight;
        } else if (root.left != null && root.right == null) {
            return 1 + leftHeight;
        } else {
            return 1 + Math.min(leftHeight, rightHeight);
        }
    }
}
```
























