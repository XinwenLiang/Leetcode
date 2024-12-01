# 代码随想录算法训练营第十八天
## [530. Minimum Avsolute Difference in BST](https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/)

Given the `root` of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.

**Example1**

![image](https://github.com/user-attachments/assets/c084a4fa-f2b4-43ed-b174-c2c5b5f4c111)

**Input:** root = [4,2,6,1,3] <br>
**Output:** 1

**Ideas:**  <br>
**Approach 1:** Convert the binary search tree (BST) into an array using in-order traversal, and then use the two-pointer technique to process the differences between adjacent elements in the array.

**Approach 2:** Directly apply the two-pointer technique within the BST itself. Define a pre pointer that points to the previous node relative to the cur pointer, and then perform an in-order traversal of the BST.

```Java
public class MinimumDifferenceInBST {
    TreeNode pre;
    int result = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root){
        if(root == null) return 0;
        traversal(root);
        return result;
    }
    public void traversal(TreeNode root){
        if(root == null) return;
        traversal(root.left);
        if(pre != null){
            result = Math.min(result, root.val - pre.val);
        }
        pre = root;
        traversal(root.right);
    }
}
```

## [501. Find Mode in BST](https://leetcode.com/problems/find-mode-in-binary-search-tree/description/)

Given the `root` of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently occurred element) in it.

If the tree has more than one mode, return them **in any order**.

Assume a BST is defined as follows:

* The left subtree of a node contains only nodes with keys **less than or equal** to the node's key.
* The right subtree of a node contains only nodes with keys **greater than or equal** to the node's key.
* Both the left and right subtrees must also be binary search trees.

**Example1**

![image](https://github.com/user-attachments/assets/b3e26a42-0d6d-4032-803d-ca97b2d64c6c)

**Input:** root = [1,null,2,2]<br>
**Output:** [2]

**Ideas:** <br>
**Approach 1:** Convert the binary search tree (BST) into a sorted array and find the mode(s) of the array.

**Approach 2:** Use the two-pointer technique to traverse the BST in a single pass, continuously updating the frequency of elements. Add the elements with the highest frequency to the 
output set.

```Java
public class FindMode {
    TreeNode pre;
    ArrayList<Integer> result;
    int count;
    int MaxCount;
    public int[] findMode(TreeNode root){
        result = new ArrayList<>();
        MaxCount = 0;
        count = 0;
        pre = null;
        find(root);
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    public void find(TreeNode root){
        if(root == null) return;
        find(root.left);
        if(pre == null || root.val != pre.val) {
            count = 1;
        }else{
            count ++;
        }
        //Update the result.
        if(count > MaxCount){
            result.clear();
            result.add(root.val);
            MaxCount = count;
        }else if(count == MaxCount){
            result.add(root.val);
        }
        pre = root; // To keep pre before the root forever,
        find(root.right);
    }
}
```























