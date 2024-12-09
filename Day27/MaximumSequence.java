package Day27;

public class MaximumSequence {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int sum = 0;
        int count = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
           count = Math.max(sum, count);
           if(sum <= 0){
               sum = 0;
           }
        }
        return count;
    }
}
