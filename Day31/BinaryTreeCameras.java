package Day31;

import Day12.TreeNode;

public class BinaryTreeCameras {
    int result = 0;
    public int minCameraCover(TreeNode root) {
        // Case4: When the root has no cover, we need to set a camera.
        if(traversal(root) == 0){
            result ++;
        }
        return result;
    }
    public int traversal(TreeNode cur){
        if(cur == null) return 2;
        int left = traversal(cur.left);
        int right = traversal(cur.right);
        // Case1:Both the left and right child have the cover.
        if(left == 2 && right == 2) return 0;
        // Case2: The left and right child have at least one no-cover.
        if(left == 0 || right == 0){
            result++;
            return 1;
        }
        // Case3: The left and right child have at least one cover.
        if(left == 1 || right == 1) return 2;
        return -1;
    }
}
