package Day14;

import Day12.TreeNode;

public class MaximumDepth {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        int height = 1+ Math.max(leftHeight, rightHeight);
        return height;
    }
}
