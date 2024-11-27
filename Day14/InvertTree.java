package Day14;

import Day12.TreeNode;

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

