package Day36;

public class LastStonesWeight {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += stones[i];
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - 2 * dp[target];
    }
}
