package Day51;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NumOfIslands02 {
    public static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // Represents four directions.
    public static void bfs(boolean[][] visited, int[][]grid, int X, int Y){
        Queue<pair> queue = new LinkedList<pair>();
        queue.add(new pair(X,Y));
        visited[X][Y] = true;
        while(!queue.isEmpty()){
            int curX = queue.peek().first;
            int curY = queue.poll().second;
            for (int i = 0; i < 4; i++) {
                int nextX = curX +dir[i][0];
                int nextY = curY + dir[i][1];
                if(nextX <0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length){
                    continue;
                }
                if(!visited[nextX][nextY] && grid[nextX][nextY] == 1){
                    queue.add(new pair(nextX, nextY));
                    visited[nextX][nextY] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int m = myScanner.nextInt();
        int n = myScanner.nextInt();
        int[][] grid = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = myScanner.nextInt();
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j] && grid[i][j] == 1){
                    ans++;
                    bfs(visited, grid, i,j);
                }
            }
        }
        System.out.println(ans);
    }
}
class pair{
    int first;
    int second;

    public pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
