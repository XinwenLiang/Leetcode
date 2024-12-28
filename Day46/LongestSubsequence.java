package Day46;

public class LongestSubsequence {
    public int longestPalindromeSubseq(String s) {
        char[] nums = s.toCharArray();
        int[][] dp = new int[nums.length][nums.length];
        // Initialize the dp array.
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                }
            }
        }
        for (int i = nums.length-1; i >= 0 ; i--) {
            for (int j = i+1; j < nums.length ; j++) {
                if(nums[i] == nums[j]){
                    dp[i][j] = dp[i+1][j-1]+2;
                }else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][nums.length-1];
    }
}
