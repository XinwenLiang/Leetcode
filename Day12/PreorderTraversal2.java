package Day12;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();
        if (root != null) st.push(root);
        while (!st.isEmpty()) {
            TreeNode node = st.peek();
            if (node != null) {
                st.pop();
                if (node.right != null) st.push(node.right);
                if (node.left != null) st.push(node.left);
                st.push(node);
                st.push(null); // Mark the middle node.
            } else {
                st.pop();
                node = st.peek();
                st.pop();
                result.add(node.val);
            }
        }
        return result;
    }
}
