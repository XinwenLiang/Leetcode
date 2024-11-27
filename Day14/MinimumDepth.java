package Day14;

import Day12.TreeNode;

public class MinimumDepth {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = minDepth(root.left);
        int rightHeight = minDepth(root.right);
        if (root.left == null && root.right != null) {
            return 1 + rightHeight;
        } else if (root.left != null && root.right == null) {
            return 1 + leftHeight;
        } else {
            return 1 + Math.min(leftHeight, rightHeight);
        }
    }
}
