package Day35;

import java.util.Scanner;

public class Knapsack2 {
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
        int[] dp = new int[bagWeight + 1];

        // Initialize the dp array.
        dp[0] = 0;

        for (int i = 1; i < n ; i++) {
            for (int j = bagWeight; j >= weight[i] ; j--) {
                dp[j] = Math.max(dp[j],dp[j-weight[i]] + value[i]);
            }
        }
        System.out.println(dp[bagWeight]);
    }
}
