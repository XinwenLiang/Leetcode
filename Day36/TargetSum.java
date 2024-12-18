package Day36;

public class TargetSum {
    public int findTargetSumWays(int[] nums, int target){
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if((sum + target) % 2 == 1 || Math.abs(target)>sum) return 0;
        int bagSize = (sum + target)/2;
        int[] dp = new int[bagSize +1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = bagSize; j >= nums[i] ; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[bagSize];
    }
}
