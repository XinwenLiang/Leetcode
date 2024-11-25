# 代码随想录算法训练营第12天
## Types of Binary Tree
1. **Full binary tree:** A binary tree is a full binary tree if it contains only nodes with a degree of `0` or `2`, and all nodes with a degree of `0` are on the same level.
`depth = k`, `number of nodes = 2^k-1`
  <p align="center">
  <img src="https://github.com/user-attachments/assets/1a4dd212-8ccf-4f0f-9e40-5e1583eebf8b" alt="Full binary tree" width="600">
</p>


2. **Complete binary tree:** In a complete binary tree, every level is fully filled except possibly the lowest level, which is filled from left to right without any gaps. If the lowest level is the h-th level (h starting from 1), it contains between 1 and 2^(h-1) nodes.

 <p align="center">
  <img src="https://github.com/user-attachments/assets/752c7746-75ed-4272-ae62-094625be222c" alt="Not a Complete Tree" width="600">
</p>

3. **Binary search tree:** Unlike the previously introduced trees which do not contain numerical values, a binary search tree does have numerical values. A binary search tree is an ordered tree:

* If its left subtree is not empty, all nodes in the left subtree have values less than the value of its root node;
* If its right subtree is not empty, all nodes in the right subtree have values greater than the value of its root node;
* Both its left and right subtrees are also binary search trees.

<p align="center">
  <img src="https://github.com/user-attachments/assets/6a30cadc-726a-4df2-a4cd-6f2fdbc1a57b" alt="A binary search tree" width="600">
</p>



4. **Balanced binary search tree:** A balanced binary search tree, also known as an AVL (Adelson-Velsky and Landis) tree, has the following properties:

* It is either an empty tree or a tree where the absolute height difference between its left and right subtrees does not exceed 1.
* Additionally, both its left and right subtrees are themselves balanced binary trees.

<p align="center">
  <img src="https://github.com/user-attachments/assets/b3922a6d-87fd-440b-b88a-9dd6b08e2e18" alt="A balanced binary search tree" width="600">
</p>

## Storage Methods for Binary Trees
Binary trees can be stored using either **linked storage** or **linear storage**.

* **Linked storage:** Uses pointers to connect nodes.
* **Linear storage:** Uses arrays to represent the tree.<br>
An example of the linked storage method is shown in the diagram.

<p align="center">
  <img src="https://github.com/user-attachments/assets/c19d8b93-9990-477e-a11a-f82a8d23c3e5" alt="Linked storage for binary tree" width="600">
</p>

If the array index of the parent node is `i`, then its left child is at index `i * 2 + 1`, and its right child is at index `i * 2 + 2`. Linear storage method is shown in the diagram.

<p align="center">
  <img src="https://github.com/user-attachments/assets/51609e2e-7145-4f9a-b05a-ac97fe9bcd4e" alt="Linear storage for binary tree" width="600">
</p>

## Traversal Methods for Binary Trees

There are two main traversal methods:

* **Depth-First Traversal:** This method goes deep into the tree first, exploring nodes down to the leaf before backtracking.
* **Breadth-First Traversal:** This method traverses the tree level by level.
### Depth-First Traversal
* **Pre-order traversal:** Visits nodes in the order: root → left → right.
* **In-order traversal:** Visits nodes in the order: left → root → right.
* **Post-order traversal:** Visits nodes in the order: left → right → root.
Both recursive and iterative methods can be used for these traversals.<br>
In depth-first traversal, the terms "pre-order," "in-order," and "post-order" refer to the order in which the root node is visited relative to its left and right children.
### Breadth-First Traversal
**Level-order traversal:** Traverses the tree one level at a time. This is typically implemented iteratively.





















