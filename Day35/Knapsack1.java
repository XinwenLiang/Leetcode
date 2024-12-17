package Day35;

import java.util.Scanner;

public class Knapsack1 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int n = myScanner.nextInt();
        int bagWeight = myScanner.nextInt();

        int[] weight = new int[n];
        int[] value = new int[n];

        for (int i = 0; i < n; i++) {
            weight[i] = myScanner.nextInt();
        }
        for (int j = 0; j < n; j++) {
            value[j] = myScanner.nextInt();
        }
        int[][] dp = new int[n][bagWeight + 1];

        // Initialize the dp array.
        for (int j = weight[0]; j <= bagWeight; j++) {
            dp[0][j] = value[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= bagWeight; j++) {
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        System.out.println(dp[n - 1][bagWeight]);
    }
}
