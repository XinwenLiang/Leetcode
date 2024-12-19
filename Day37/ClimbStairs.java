package Day37;

import java.util.Scanner;

public class ClimbStairs {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int m = myScanner.nextInt(); // The steps we can take.
        int n = myScanner.nextInt(); // The nth stair.
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int j = 0; j<= n; j++){
            for (int i = 0; i <=m; i++) {
                if(j-i >= 0){
                    dp[j] += dp[j-i];
                }
            }
            System.out.println(dp[n]);
        }
    }
}
