package Day21;

import Day12.TreeNode;


public class ConstructBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = construct(nums, 0, nums.length - 1);
        return root;
    }

    public TreeNode construct(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = construct(nums, left, mid - 1);
        root.right = construct(nums, mid + 1, right);
        return root;
    }
}
