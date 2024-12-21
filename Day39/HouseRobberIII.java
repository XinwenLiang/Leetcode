package Day39;

import Day12.TreeNode;

public class HouseRobberIII {
    public int rob(TreeNode root) {
        int[] dp = robAction(root);
        return Math.max(dp[0], dp[1]);
    }
    int[] robAction(TreeNode root){
        int[] dp = new int[2];
        if(root == null) return dp;
        // Post-order Traversal.
        int[] left = robAction(root.left);
        int[] right = robAction(root.right);

        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        dp[1] = root.val + left[0] + right[0];
        return dp;
    }
}
