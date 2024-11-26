package Day12;

import Day12.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> result =  new ArrayList<>();
        preorder(root, result);
        return result;
    }
    public void preorder(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }
        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }
}
