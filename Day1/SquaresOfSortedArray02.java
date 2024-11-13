package Day1;

import java.util.Arrays;

public class SquaresOfSortedArray02 {
    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

    public static int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int index = nums.length - 1;
        int[] arrNew = new int[nums.length];
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                arrNew[index] = nums[left] * nums[left];
                index--;
                left++;
            } else {
                arrNew[index] = nums[right] * nums[right];
                index--;
                right--;
            }
        }
        return arrNew;
    }
}
