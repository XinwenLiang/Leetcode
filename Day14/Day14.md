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
























