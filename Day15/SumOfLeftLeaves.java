package Day15;

import Day12.TreeNode;

public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root){
        if (root == null) return 0;
        int leftValue = sumOfLeftLeaves(root.left);
        int rightValue = sumOfLeftLeaves(root.right);

        int midValue = 0;
        if(root.left != null && root.left.left == null && root.left.right == null){
            midValue = root.left.val;
        }
        int sum = leftValue + rightValue + midValue;
        return sum;
    }
}
