package Day12;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public List<List<Integer>> resList = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        checkFun(root);
        return resList;
    }

    public void checkFun(TreeNode node) {
        if (node == null) return;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(node);

        while (!que.isEmpty()) {
            List<Integer> itemList = new ArrayList<Integer>();
            int size = que.size();

            while (size > 0) {
                TreeNode temp = que.poll();
                itemList.add(temp.val);

                if (temp.left != null) que.offer(temp.left);
                if (temp.right != null) que.offer(temp.right);
                size--;
            }
            resList.add(itemList);
        }
    }
}

