package Day52;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class BuildLargestIsland {
    static int count;
    static int mark;
    static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

    public static void dfs(int[][] grid, int x, int y, boolean[][] visited){
        if(x < 0 || x >= grid.length || y < 0 || y <= grid[0].length) return;
        if(visited[x][y] || grid[x][y]== 0 ) return;

        visited[x][y] = true;
        count++;
        grid[x][y] = mark;

        dfs(grid,x,y+1, visited);
        dfs(grid, x, y-1, visited);
        dfs(grid,x-1,y,visited);
        dfs(grid,x+1, y, visited);
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
        mark = 2;
        HashMap<Integer,Integer> getSize = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        boolean isAllIslands = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 0) isAllIslands = false;
                if(grid[i][j] == 1) {
                    count = 0;
                    dfs(grid,i,j,visited);
                    getSize.put(mark,count);
                    mark++;
                }
            }
        }
        int result = 0;
        if(isAllIslands) result = m*n;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[0][0] == 0) set.clear();
                int curSize = 0;

                for(int[] d: dir){
                    int curRow = i + d[0];
                    int curColumn = j + d[1];
                    if(curRow < 0 || curRow >= grid.length || curColumn < 0 || curColumn >= grid[0].length) continue;
                    int curMark = grid[curRow][curColumn];
                    if(set.contains(curMark) || !getSize.containsKey(curMark)) continue;
                    set.add(curMark);
                    curSize += getSize.get(curMark);
                }
                result = Math.max(result, curSize);
            }
        }
        System.out.println(result);
    }
}
