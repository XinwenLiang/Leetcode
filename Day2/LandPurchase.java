package Day2;

import java.util.Scanner;

public class LandPurchase {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int n = myScanner.nextInt();
        int m = myScanner.nextInt();
        int sum = 0;
        int[][] vec = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                vec[i][j] = myScanner.nextInt();
                sum += vec[i][j]; // Calculate the total value of the land.
            }
        }
        int result = Integer.MAX_VALUE;
        int count = 0;//Used to store the cumulative sum of traversed areas.

        // Horizontal division.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                count += vec[i][j];
                // Update the minimum difference when traversing to the end of the row.
                if(j==m-1){
                    result = Math.min(result, Math.abs(sum-2*count));
                }
            }
        }

        // Vertical division.
        count = 0;
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                count += vec[i][j];
                // Update the minimum difference when traversing to the end of the column.
                if(i==n-1){
                    result = Math.min(result, Math.abs(sum-2*count));
                }
            }
        }
        System.out.println(result);
        myScanner.close();
    }
}
