package Day2;

public class minSubArrLen {
    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrLen(target, nums));
    }

    public static int minSubArrLen(int target, int[] nums) {
        int left = 0; // Starting point.
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) { // The end point.
            sum += nums[i];
            while (sum >= target) {
                result = Math.min(result, i - left + 1);
                sum -= nums[left];//Removes the elements on the left border of the window from the sum in an attempt to shrink the window
                left++;
            }
        }
        return result != Integer.MAX_VALUE ? result : 0;
    }
}
