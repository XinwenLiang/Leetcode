package Day17;

import Day12.TreeNode;

public class ConstructMaximumTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length);
    }
    public TreeNode construct(int[] nums, int leftIndex, int rightIndex){
        if(rightIndex - leftIndex < 1){
            return null;
        }
        if(rightIndex - leftIndex == 1){
            return new TreeNode(nums[leftIndex]);
        }
        int index = leftIndex;
        int maxVal = nums[leftIndex];
        for (int i = leftIndex + 1; i < rightIndex; i++) {
            if(nums[i] > maxVal){
                maxVal = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(maxVal);
        root.left = construct(nums, leftIndex, index); // Left-closed, right-open interval
        root.right = construct(nums, index+1, rightIndex); //Left-closed, right-open interval
        return root;
    }
}
