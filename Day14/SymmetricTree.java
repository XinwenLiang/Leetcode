package Day14;

import Day12.TreeNode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return compare(root.left, root.right);
    }

    public boolean compare(TreeNode left, TreeNode right){
        if(left == null && right != null){
            return false;
        }else if(left != null && right == null){
            return  false;
        }else if(left == null && right == null){
            return true;
        }else if(left.val != right.val){
            return false;
        }
        // Compare the outside.
        boolean outside = compare(left.left, right.right);
        boolean inside = compare(left.right, right.left);
        return outside && inside;
    }
}
