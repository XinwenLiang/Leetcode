package Day20;

import Day12.TreeNode;

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
