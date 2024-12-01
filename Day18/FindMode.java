package Day18;

import Day12.TreeNode;

import java.util.ArrayList;

public class FindMode {
    TreeNode pre;
    ArrayList<Integer> result;
    int count;
    int MaxCount;
    public int[] findMode(TreeNode root){
        result = new ArrayList<>();
        MaxCount = 0;
        count = 0;
        pre = null;
        find(root);
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    public void find(TreeNode root){
        if(root == null) return;
        find(root.left);
        if(pre == null || root.val != pre.val) {
            count = 1;
        }else{
            count ++;
        }
        //Update the result.
        if(count > MaxCount){
            result.clear();
            result.add(root.val);
            MaxCount = count;
        }else if(count == MaxCount){
            result.add(root.val);
        }
        pre = root; // To keep pre before the root forever,
        find(root.right);
    }
}
