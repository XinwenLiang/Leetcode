package Day43;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums){
        if (nums.length == 1) return 1;
        int[] dp = new int[nums.length];
        // Initialize the dp array.
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < nums.length ; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        int result = 0;
        for(int num : dp){
            result = Math.max(result, num);
        }
        return result;
    }
}
