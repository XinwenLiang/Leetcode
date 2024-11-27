# Binary Tree Level Order Traversal 
**Ideas:** Binary Tree Level Order Traversal (equivalent to Breadth-First Search in graph theory).

We use a queue to store the elements of each level during traversal and then record the length of
the queue to control the number of elements to output and the number of iterations for each level. 
For the detailed process, refer to the animation shown below:(from https://github.com/youngyangyang04/leetcode-master)

![102二叉树的层序遍历](https://code-thinking.cdn.bcebos.com/gifs/102%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E5%B1%82%E5%BA%8F%E9%81%8D%E5%8E%86.gif)

```Java
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
```
