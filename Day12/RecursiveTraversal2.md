# Iterative Implementation of Preorder, Inorder, and Postorder Traversal for Binary Trees
## Preorder Traversal (Root-Left-Right)
In preorder traversal, the root node is processed first, followed by the left subtree and then the right subtree. Using a stack helps simulate the recursive process iteratively.

Algorithm:

* Push the root node onto the stack.
* While the stack is not empty:
* Pop the top node from the stack and add its value to the result list.
* Push the right child (if exists) onto the stack.
* Push the left child (if exists) onto the stack.

