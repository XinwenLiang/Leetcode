package Day15;

import Day12.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AllPaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> path = new ArrayList<>();
        traversal(root, path, result);
        return result;
    }

    public void traversal(TreeNode root, List<Integer> path, List<String> result) {
        path.add(root.val); // Preorder traversal.
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++) {
                sb.append(path.get(i)).append("->");
            }
            sb.append(path.get(path.size() - 1));
            result.add(sb.toString());
            return;
        }
        if (root.left != null) {
            traversal(root.left, path, result);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            traversal(root.right, path, result);
            path.remove(path.size() - 1); // Backtrack.
        }
    }
}
