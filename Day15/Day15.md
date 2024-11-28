# 代码随想录算法训练营第十五天
## [101. Balanced Binary Tree](https://leetcode.com/problems/balanced-binary-tree/description/)

Given a binary tree, determine if it is height-balanced.

**Example1**

![image](https://github.com/user-attachments/assets/548e777f-de44-438f-8562-713dfbfca3f3)

**Input:** root = [3,9,20,null,null,15,7]<br>
**Output:** true

**Ideas:** The definition of a balanced binary tree is that the height difference between the left and right subtrees of any node does not exceed 1. Therefore, this problem essentially involves traversing the binary tree to calculate the height difference of the left and right subtrees for each node and then comparing them. To determine the height, we use the post-order traversal method.

```Java
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root){
        return getHeight(root) != -1;
    }
    public int getHeight(TreeNode root){
        if(root == null) return 0;
        int leftHeight = getHeight(root.left);
        if(leftHeight == -1) return -1;
        int rightHeight = getHeight(root.right);
        if(rightHeight == -1) return -1;
        int result;
        if(Math.abs(rightHeight - leftHeight) > 1) result = -1;
        else{
            result = 1 + Math.max(rightHeight, leftHeight);
        }
        return result;
    }
}
```

## [257. Binary Trees Paths](https://leetcode.com/problems/binary-tree-paths/description/)

Given the `root` of a binary tree, return all root-to-leaf paths in **any order**.

A **leaf** is a node with no children.

**Example1**

![image](https://github.com/user-attachments/assets/4df154ef-c870-4fe7-b6fd-bdbbebfa6237)

**Input:** root = [1,2,3,null,5] <br>
**Output:** ["1->2->5","1->3"]

**Ideas:** For this problem, we need an array to store the path of a single level and another string array as the result set. We use pre-order traversal to traverse the entire binary tree (because only pre-order traversal reflects the parent node pointing to child nodes). Additionally, since we need to return to the parent node to traverse the other side after reaching a leaf node on one side, this problem inherently involves a backtracking process.

```Java
public class AllPaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> path = new ArrayList<>();
        traversal(root, path, result);
        return result;
    }

    public void traversal(TreeNode root, List<Integer> path, List<String> result) {
        path.add(root.val); // Preorder traversal.
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++) {
                sb.append(path.get(i)).append("->");
            }
            sb.append(path.get(path.size() - 1));
            result.add(sb.toString());
            return;
        }
        if (root.left != null) {
            traversal(root.left, path, result);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            traversal(root.right, path, result);
            path.remove(path.size() - 1); // Backtrack.
        }
    }
}
```
## [404. Sum of Left Leaves](https://leetcode.com/problems/sum-of-left-leaves/description/)
Given the `root` of a binary tree, return the sum of all left leaves.

A **leaf** is a node with no children. A **left leaf** is a leaf that is the left child of another node.

**Example1:** <br>
![image](https://github.com/user-attachments/assets/c1a195cf-f829-4623-9eb5-54353a6bcd32)

**Input:** root = [3,9,20,null,null,15,7]<br>
**Output:** 24<br>
**Explanation:** There are two left leaves in the binary tree, with values 9 and 15 respectively.

**Ideas:** The left leaf must be a leaf node, meaning its left and right children must both be null, and it must also be the left child of its parent node. Then, we use the post-order traversal method to traverse the entire binary tree.

```Java
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root){
        if (root == null) return 0;
        int leftValue = sumOfLeftLeaves(root.left);
        int rightValue = sumOfLeftLeaves(root.right);

        int midValue = 0;
        if(root.left != null && root.left.left == null && root.left.right == null){
            midValue = root.left.val;
        }
        int sum = leftValue + rightValue + midValue;
        return sum;
    }
}
```

## [222. Count Complete Tree Nodes](https://leetcode.com/problems/count-complete-tree-nodes/description/)

Given the `root` of a complete binary tree, return the number of the nodes in the tree.

According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between `1` and `2h` nodes inclusive at the last level h.

Design an algorithm that runs in less than `O(n)` time complexity.

**Example1** <br>

![image](https://github.com/user-attachments/assets/d8f9ae2e-6964-4426-993e-ec69b50fb28f)

**Input:** root = [1,2,3,4,5,6]<br>
**Output:** 6

**Ideas:** We realize that the number of nodes in a full binary tree can be quickly calculated using the formula `2^depth-1`. Therefore, we can leverage this property of full binary trees 
to calculate the total number of nodes in a complete binary tree. How do we determine whether a subtree is a full binary tree? We simply recursively traverse to the left to calculate the 
left depth or traverse to the right to calculate the right depth. If the two depths are equal, the subtree is a full binary tree. Then, we calculate the total number of nodes in the left 
and right subtrees separately, and the final result is the sum of the two.

```Java
public class CountNodes {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftDepth = 0; int rightDepth = 0;
        while(left != null){
            left = left.left;
            leftDepth++;
        }
        while(right != null){
            right = right.right;
            rightDepth++;
        }
        if(leftDepth == rightDepth){
            return (2<<leftDepth) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
```


































