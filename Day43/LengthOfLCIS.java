package Day43;

public class LengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 1) return 1;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < nums.length ; i++) {
           if(nums[i] > nums[i-1]){
               dp[i] = dp[i-1] + 1;
            }
        }
        int result = 0;
        for(int num : dp){
            result = Math.max(result, num);
        }
        return result;
    }
}
