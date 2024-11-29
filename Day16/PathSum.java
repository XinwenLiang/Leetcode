package Day16;

import Day12.TreeNode;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum){
        if (root == null) return false;
        targetSum -= root.val;
        if(root.left == null && root.right == null){
            return targetSum == 0;
        }
        if(root.left != null){ // Find a path from the child of left tree.
            boolean left = hasPathSum(root.left, targetSum);
            if(left) return true;
        }
        if(root.right != null){// Find a path from the child of right tree.
            boolean right = hasPathSum(root.right, targetSum);
            if(right) return true;
        }
        return false;
    }
}
