# 代码随想录算法训练营第二十天
## [235. Lowest Common Ancestor of a Binary Search Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/)

Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes `p` and `q` as the lowest node in T that has both `p` and `q` as descendants (where 
we allow a node to be a descendant of itself).”

**Example1:**

![image](https://github.com/user-attachments/assets/0adf9435-04e0-4874-affc-36cd609a8956)

**Input:** root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8<br>
**Output:** 6<br>
**Explanation:** The LCA of nodes 2 and 8 is 6.

**Ideas:**  This problem is simpler than the one from yesterday because a binary search tree is inherently ordered, which provides a clear direction for our search. Additionally, there's no 
need to involve pre-order, in-order, or post-order traversal. Both the recursive and iterative approaches are straightforward to implement.

```Java
// Recursive method.
public class CommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root.val > p.val && root.val > q.val){
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            if(left != null) return left;
        }else if(root.val < p.val && root.val < q.val){
            TreeNode right = lowestCommonAncestor(root.right, p,q);
            if(right != null) return right;
        }else{
            return root;
        }
        return null;
    }
}

// Iterate method.
public class CommonAncestor02 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
}
```

## [701. Insert into a Binary Search Tree](https://leetcode.com/problems/insert-into-a-binary-search-tree/description/)

You are given the `root` node of a binary search tree (BST) and a `value` to insert into the tree. Return the root node of the BST after the insertion. It is **guaranteed** that the new value does not exist in the original BST.

**Notice** that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return **any of them**.

**Example1:**

![image](https://github.com/user-attachments/assets/63d7fd6c-dbdd-45a0-a801-ca6af5aea6aa)

**Input:** root = [4,2,7,1,3], val = 5 <br>
**Output:** [4,2,7,1,3,5]<br>
**Explanation:** Another accepted tree is:<br>
![image](https://github.com/user-attachments/assets/e1d975a7-4f04-429b-aec9-585a8618b1ac)

**Ideas:** From the problem statement, we know that the structure of the binary search tree after inserting a node is not unique, and there can be multiple possible outcomes. However, we 
can simplify the process by identifying a suitable leaf node for the insertion operation, making it less complicated.

```Java
public class InsertNode {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            TreeNode node = new TreeNode(val);
            return node;
        }if(val < root.val){
            root.left = insertIntoBST(root.left, val);
        }if(val > root.val){
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
```

##[450. Delete Node in a BST](https://leetcode.com/problems/delete-node-in-a-bst/description/)

Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the **root node reference** (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

1. Search for a node to remove.
2. If the node is found, delete the node.

**Example1**

![image](https://github.com/user-attachments/assets/6633eeca-ad1e-400c-8285-807caf2e4262)

**Input:** root = [5,3,6,2,4,null,7], key = 3<br>
**Output:** [5,4,6,2,null,null,7]<br>
**Explanation:** Given key to delete is 3. So we find the node with value 3 and delete it.<br>
One valid answer is [5,4,6,2,null,null,7], shown in the above BST.<br>
Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.

**Ideas:**<br>
This problem is relatively challenging because deleting a node in a binary search tree may change the entire structure of the tree. The node to be deleted can fall into **five** scenarios:
1. If the node to be deleted is not found, the traversal reaches a null node and simply returns.
2. If the node to be deleted has no children (a leaf node), delete the node and return NULL as the root node.
3. If the left child of the node to be deleted is null and the right child is not null, delete the node and replace it with its right child, returning the right child as the new root node.
4. If the right child of the node to be deleted is null and the left child is not null, delete the node and replace it with its left child, returning the left child as the new root node.
5. If the node to be deleted has both left and right children, attach the root node of the left subtree (the left child) to the leftmost node of the right subtree. Then, return the right
child of the deleted node as the new root node.

```Java
public class DeleteNodes {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key){
            if(root.left == null && root.right == null){
                return null;
            }else if(root.left != null && root.right == null){
                return root.left;
            }else if(root.left == null && root.right != null){
                return root.right;
            }else{
                TreeNode cur = root.right;
                while(cur.left != null){
                    cur = cur.left;
                }
                cur.left = root.left;
                root = root.right;
                return root;
            }
        }
        if(key < root.val) root.left = deleteNode(root.left, key);
        if(key > root.val) root.right = deleteNode(root.right, key);
        return root;
    }
}
```






















