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

**Ideas:**

1. Define the Parameters and Return Value of the Recursive Function: Since the goal is to print the values of the nodes during a preorder traversal, a `vector` needs to be passed as a parameter to store the node values. Apart from this, there’s no additional data to process, and no return value is required. Therefore, the return type of the recursive function is `void`.

2. Establish the Termination Condition: When the currently traversed node is null, the current layer of recursion should terminate.

3. Define the Logic for a Single Layer of Recursion: Preorder traversal follows the order of root, left, and right. Therefore, in the logic of a single layer of recursion, the value of the root node should be processed first.

```Java
public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> result =  new ArrayList<>();
        preorder(root, result);
        return result;
    }
    public void preorder(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }
        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }
}
```

## [145. Binary Tree Postorder Tree](https://leetcode.com/problems/binary-tree-postorder-traversal/description/)

Given the `root` of a binary tree, return the preorder traversal of its nodes' values.

**Example 1:**

**Input:** root = [1,null,2,3]

**Output:** [1,2,3]

**Explanation:**

![image](https://github.com/user-attachments/assets/fab128f1-a2fc-419f-ac35-3d9df0167eaa)

**Ideas**: Only the third process is different frow preorder traversal. The new order is left, right, and middle.

```Java
public class PostorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    public void postorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        postorder(root.left, result);
        postorder(root.right, result);
        result.add(root.val);
    }
}
```

## [94.Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/description/)

Given the `root` of a binary tree, return the preorder traversal of its nodes' values.

**Example 1:**

**Input:** root = [1,null,2,3]

**Output:** [1,2,3]

**Explanation:**

![image](https://github.com/user-attachments/assets/fab128f1-a2fc-419f-ac35-3d9df0167eaa)

**Ideas:** Only the third process is different frow preorder traversal. The new order is left, middle and right.

```Java
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    public void inorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }
}
```






















