package Day51;

import java.util.Scanner;

public class MaxAreaIslands {
    public static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public static int result = 0;
    public static int count = 0;
    public static void dfs(int[][] grid, boolean[][] visited, int x, int y){
        count++;
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];
            if(nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid[0].length ||grid[nextX][nextY] == 0 || visited[nextX][nextY]){
                continue;
            }
            dfs(grid, visited, nextX, nextY);
        }
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int m = myScanner.nextInt();
        int n = myScanner.nextInt();
        int[][] grid = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = myScanner.nextInt();
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j] && grid[i][j] == 1){
                    count = 0;
                    dfs(grid,visited,i,j);
                    result = Math.max(count,result);
                }
            }
        }
        System.out.println(result);
    }
}
