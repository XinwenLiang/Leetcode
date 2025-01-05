package Day53;

import java.util.Scanner;

public class PerimeterOfIsland {
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int count;

    public static void helper(int[][] grid, int x, int y) {
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];

            // when meet the border or water, add 1 to the perimeter.
            if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length
                    || grid[nx][ny] == 0) {
                count++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int result = 0; // 总周长
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count = 0;
                    helper(grid, i, j);
                    // update the new perimeter.
                    result += count;
                }
            }
        }

        System.out.println(result);
    }
}
