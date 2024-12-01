package Day18;

import Day12.TreeNode;

public class MinimumDifferenceInBST {
    TreeNode pre;
    int result = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root){
        if(root == null) return 0;
        traversal(root);
        return result;
    }
    public void traversal(TreeNode root){
        if(root == null) return;
        traversal(root.left);
        if(pre != null){
            result = Math.min(result, root.val - pre.val);
        }
        pre = root;
        traversal(root.right);
    }
}
