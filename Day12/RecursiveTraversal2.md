# Iterative Implementation of Preorder, Inorder, and Postorder Traversal for Binary Trees
## Preorder Traversal (Root-Left-Right)
In preorder traversal, the root node is processed first, followed by the left subtree and then the right subtree. Using a stack helps simulate the recursive process iteratively.

**Algorithm:**

* Push the root node onto the stack.
* While the stack is not empty:
* Pop the top node from the stack and add its value to the result list.
* Push the right child (if exists) onto the stack.
* Push the left child (if exists) onto the stack.

```Java
public class PreorderTraversal2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();
        if (root != null) st.push(root);
        while (!st.isEmpty()) {
            TreeNode node = st.peek();
            if (node != null) {
                st.pop();
                if (node.right != null) st.push(node.right);
                if (node.left != null) st.push(node.left);
                st.push(node);
                st.push(null); // Mark the middle node.
            } else {
                node = st.peek();
                st.pop();
                result.add(node.val);
            }
        }
        return result;
    }
}
```

## Postorder Traversal (Left-Right-Root)
In postorder traversal, nodes are processed by visiting the left subtree, then the right subtree, and finally the root. This traversal requires tracking both children before visiting the root. Using two stacks simplifies the process.

**Algorithm:**

1. Push the root node onto the first stack.
2. Pop nodes from the first stack and push them onto the second stack.
3. Push the left and right children of the popped node onto the first stack.
4. Pop nodes from the second stack (in reverse order) and add their values to the result list.


```Java
public class PreorderTraversal2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();
        if (root != null) st.push(root);
        while (!st.isEmpty()) {
            TreeNode node = st.peek();
            if (node != null) {
                st.pop();
                if (node.right != null) st.push(node.right);
                if (node.left != null) st.push(node.left);
                st.push(node);
                st.push(null); // Mark the middle node.
            } else {
                st.pop();
                node = st.peek();
                st.pop();
                result.add(node.val);
            }
        }
        return result;
    }
}
```

## Inorder Traversal (Left--Root-Right)
In inorder traversal, nodes are processed by visiting the left subtree, then the root node, and finally the right subtree. The stack helps track nodes to process while descending the left subtree.

**Algorithm:**

1. Initialize a pointer to the root and use it to traverse left nodes.
2. Push each node onto the stack until reaching the leftmost node.
3. Pop nodes from the stack:
4. Add their values to the result list.
5. Move to their right child and repeat the process.

```Java
public class InorderTraversal2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();
        if (root != null) st.push(root);
        while (!st.isEmpty()) {
            TreeNode node = st.peek();
            if (node != null) {
                st.pop();
                if (node.right != null) st.push(node.right);
                st.push(node);
                st.push(null); // Mark the middle node.
                if (node.left != null) st.push(node.left);
            } else {
                st.pop();
                node = st.peek();
                st.pop();
                result.add(node.val);
            }
        }
        return result;
    }
}
```



