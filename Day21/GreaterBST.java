package Day21;

import Day12.TreeNode;

public class GreaterBST {
    int pre;
    public TreeNode convertBST(TreeNode root) {
        pre = 0;
        traversal(root);
        return root;
    }
    public void traversal(TreeNode cur){
        if(cur == null) return;
        traversal(cur.right);
        cur.val += pre;
        pre = cur.val;
        traversal(cur.left);
    }
}
