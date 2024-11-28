package Day15;

import Day12.TreeNode;

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
