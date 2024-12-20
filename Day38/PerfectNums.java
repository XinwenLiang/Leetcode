package Day38;

public class PerfectNums {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int i = 0; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 1; i*i <= n; i++) {
            for (int j = i*i; j <= n; j++) {
                dp[j] = Math.min(dp[j-i*i] + 1, dp[j]);
            }
        }
        return dp[n];
    }
}
