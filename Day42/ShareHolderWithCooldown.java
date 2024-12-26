package Day42;

public class ShareHolderWithCooldown {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][4];
        dp[0][0] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(Math.max(dp[i-1][0],dp[i-1][1]-prices[i]),dp[i-1][3] - prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][3]);
            dp[i][2] = dp[i-1][0] + prices[i];
            dp[i][3] = dp[i-1][2];
        }
        return Math.max(Math.max(dp[len-1][1],dp[len-1][2]),dp[len-1][3]);
    }
}
