package Day1;

import java.util.Arrays;

public class SquaresOfSortedArray {
    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }
    public static int[] sortedSquares(int[] nums) {
        int[] arrNew = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arrNew[i] = nums[i] * nums[i];
        }
        // 使用冒泡排序法对新数组进行排序
        int temp = 0;
        for (int i = 0; i < arrNew.length - 1; i++) {
            for (int j = 0; j < arrNew.length - 1; j++) {
                if (arrNew[j] > arrNew[j + 1]) {
                    temp = arrNew[j];
                    arrNew[j] = arrNew[j + 1];
                    arrNew[j + 1] = temp;
                }
            }
        }
        return arrNew;
    }
}
