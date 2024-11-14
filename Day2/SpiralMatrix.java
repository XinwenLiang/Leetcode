package Day2;

import java.util.Arrays;

public class SpiralMatrix {
    public static void main(String[] args) {
        int n = 3;
        int arr[][] = generateMatrix(n);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        int startX = 0;
        int startY = 0; //Set the start point as (0,0)
        int offset = 1; // Set the variable to control the end position.
        int count = 1; // The element in the matrix.

        while (startX <= n / 2) {
            for (int j = startY; j < n - offset; j++) {
                nums[startX][j] = count;
                count++;
            }

            for (int i = startX; i < n - offset; i++) {
                nums[i][n - offset] = count;
                count++;
            }

            for (int j = n - offset; j > startY; j--) {
                nums[n - offset][j] = count;
                count++;
            }

            for (int i = n - offset; i > startX; i--) {
                nums[i][startY] = count;
                count++;
            }
            startY++;
            startX++;
            offset++;
            if (n % 2 != 0) {
                nums[n / 2][n / 2] = n * n;
            }
        }
        return nums;
    }
}
