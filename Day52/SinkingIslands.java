package Day52;

import java.util.Scanner;

public class SinkingIslands {
    static int[][] dir ={{0,1},{0,-1},{1,0},{-1,0}};

    public static void dfs(int[][] grid, int x, int y){
        grid[x][y] = 2;
        for(int []d : dir){
            int nextX = x + d[0];
            int nextY = y + d[1];
            if(nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length) continue;
            if(grid[nextX][nextY] == 2 || grid[nextX][nextY] == 0) continue;
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
        // Step1: Find all cells with 1 (land) and expand from there, marking as 2.
        for (int i = 0; i < n; i++) {
            if(grid[i][0] == 1) dfs(grid, i, 0);
            if(grid[i][m-1]==1) dfs(grid, i, m-1);
        }
        for (int j = 0; j < m; j++) {
            if(grid[0][j] == 1) dfs(grid, 0,j);
            if(grid[n-1][j]==1) dfs(grid, n-1, j);
        }

        // Step2: Change all cells marked as 2 to 0, effectively sinking these isolated islands.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == 1) grid[i][j]=0;
                if(grid[i][j] == 2) grid[i][j] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        myScanner.close();
    }
}
