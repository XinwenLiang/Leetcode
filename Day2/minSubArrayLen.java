package Day2;

public class minSubArrayLen {
    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(target, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE; //Initialize the maximum value of type int.
        int sum = 0;
        int subLength = 0;
        for (int i = 0; i < nums.length; i++) { //Set the starting point of the subsequence to be i.
            sum = 0;
            for (int j = i; j < nums.length; j++) {//Set the end point of the subsequence to be j.
                sum += nums[j];
                if (sum >= target) {
                    subLength = j - i + 1;
                    result = Math.min(result, subLength);
                    break; //Once meet the condition, break the loop.
                }
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
