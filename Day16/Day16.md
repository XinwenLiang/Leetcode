# 代码随想录算法训练营第十六天
## [513. Find Bottom Left Tree Value](https://leetcode.com/problems/find-bottom-left-tree-value/description/)

Given the `root` of a binary tree, return the leftmost value in the last row of the tree.

**Example1**<br>
![image](https://github.com/user-attachments/assets/6a11a5ed-c7bc-40be-a96b-0c5d7287c744)

**Input:** root = [2,1,3] <br>
**Output:** 1

**Ideas:** This problem involves finding the value of the leftmost leaf node in the last row of a binary tree. While using level-order traversal is a more straightforward approach, I opted to 
use recursion to traverse the entire binary tree during my first attempt.

```Java
public class FindNodes {
    private int depth = -1;
    private int value = 0;

    public int findBottomLeftValue(TreeNode root) {
        value = root.val;
        findLeftValue(root, 0);
        return value;
    }

    public void findLeftValue(TreeNode root, int deep) {
        if (root == null) return;
        if (root.left == null && root.right == null) {// Leaf node.
            if (deep > depth) {
                value = root.val;
                depth = deep;
            }
        }
        if (root.left != null) findLeftValue(root.left, deep + 1);
        if (root.right != null) findLeftValue(root.right, deep + 1);

    }
}
```

## [112. Path Sum](https://leetcode.com/problems/path-sum/description/)
Given the `root` of a binary tree and an integer `targetSum`, return `true` if the tree has a **root-to-leaf** path such that adding up all the values along the path equals `targetSum`.

A **leaf** is a node with no children.

**Example1** <br>
![image](https://github.com/user-attachments/assets/ff7d4367-83fc-49ca-aa1e-f3e61cfdbab1)

**Input:** root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22 <br>
**Output:** true <br>
**Explanation:** The root-to-leaf path with the target sum is shown.

**Ideas:**  Since this problem does not involve processing logic for intermediate nodes, any traversal method—pre-order, in-order, or post-order—can be used. We can initialize a counter 
with the target value and traverse the nodes one by one, decrementing the counter by the value of each node. If we reach a leaf node and the counter has not yet reached zero, a backtracking 
operation is required to return to the previous step.

```Java
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum){
        if (root == null) return false;
        targetSum -= root.val;
        if(root.left == null && root.right == null){
            return targetSum == 0;
        }
        if(root.left != null){ // Find a path from the child of left tree.
            boolean left = hasPathSum(root.left, targetSum);
            if(left) return true;
        }
        if(root.right != null){// Find a path from the child of right tree.
            boolean right = hasPathSum(root.right, targetSum);
            if(right) return true;
        }
        return false;
    }
}
```

## [106. Construct Binary Tree from Inorder and Postorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/)
Given two integer arrays `inorder` and `postorder` where `inorder` is the inorder traversal of a binary tree and `postorder` is the postorder traversal of the same tree, construct and 
return the binary tree.

**Example 1:** <br>
![image](https://github.com/user-attachments/assets/10f2cc68-c308-4599-a946-97ce952f731e)

**Input:** inorder = [9,3,15,20,7], postorder = [9,15,7,20,3] <br>
**Output:** [3,9,20,null,null,15,7]

**Ideas:**

This problem begins with the clarification that in-order and post-order traversals can uniquely determine a binary tree, and pre-order and in-order traversals can also uniquely determine a 
binary tree. However, post-order and pre-order traversals cannot uniquely determine a binary tree, as it is impossible to determine how to divide the left and right subtrees.

The solution involves the following steps:

1. If the post-order array is empty, return a null node.
2. The last element in the post-order array represents the root node.
3. Locate the root node's position in the in-order array, which serves as the dividing point.
4. Divide the in-order array into left and right subtrees.
5. Divide the post-order array into left and right subtrees.
6. Recursively process the left and right subtrees.

```Java
public class ConstructTree {
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return findNode(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    public TreeNode findNode(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
        if (inBegin >= inEnd || postBegin >= postEnd) { // Empty array means null node.
            return null;
        }
        int rootIndex = map.get(postorder[postEnd - 1]); // Get the index of the root.
        TreeNode root = new TreeNode(inorder[rootIndex]);
        int lenOfLeft = rootIndex - inBegin;
        root.left = findNode(inorder, inBegin, rootIndex, postorder, postBegin, postBegin + lenOfLeft);
        root.right = findNode(inorder, rootIndex + 1, inEnd, postorder, postBegin + lenOfLeft, postEnd - 1);
        return root;
    }
}
```

























