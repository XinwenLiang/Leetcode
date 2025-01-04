package Day52;

import java.util.Scanner;

public class TotalArea {
    static int[][] dir ={{0,1},{0,-1},{1,0},{-1,0}};
    static int count =0;
    public static void dfs(int[][] grid, int x,int y){
        grid[x][y] = 0;
        count++;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];
            if(nextX >= grid.length || nextX <0 || nextY >= grid[0].length || nextY < 0) continue;
            if(grid[nextX][nextY] == 0) continue;
            dfs(grid, nextX, nextY);
        }
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int n = myScanner.nextInt();
        int m = myScanner.nextInt();

        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
               grid[i][j] = myScanner.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            if(grid[i][0] == 1) dfs(grid, i,0);
            if(grid[i][m-1] == 1) dfs(grid, i, m-1);
        }
        for (int j = 0; j < m; j++) {
            if(grid[0][j] == 1) dfs(grid,0,j);
            if(grid[n-1][j] == 1) dfs(grid, n-1,j);
        }
        count = 0;
        for (int i = 1; i < n-1; i++) {
            for (int j = 1; j < m-1; j++) {
                if(grid[i][j] == 1) {
                    count = 0;
                    dfs(grid,i,j);
                    System.out.println(count);
                }
            }
        }
    }
}
