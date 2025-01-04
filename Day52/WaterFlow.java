package Day52;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WaterFlow {
    public static void dfs(int[][] heights, int x, int y, boolean[][] visited, int preH){
        if(x < 0 || x >= heights.length || y< 0 || y >= heights.length || visited[x][y]) return;
        if(heights[x][y] < preH) return;
        visited[x][y] = true;

        dfs(heights, x+1,y,visited, heights[x][y]);
        dfs(heights, x-1, y, visited, heights[x][y]);
        dfs(heights,x,y+1, visited, heights[x][y]);
        dfs(heights,x,y-1,visited,heights[x][y]);
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int m = myScanner.nextInt();
        int n = myScanner.nextInt();

        int [][] heights = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                heights[i][j] = myScanner.nextInt();
            }
        }
        // The border.
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(heights,i,0,pacific,Integer.MIN_VALUE);
            dfs(heights,i,n-1,atlantic,Integer.MIN_VALUE);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, 0,j,pacific,Integer.MIN_VALUE);
            dfs(heights,m-1,j,atlantic,Integer.MIN_VALUE);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Get the intersection.
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        for (List<Integer> list : res) {
            for (int k = 0; k < list.size(); k++) {
                if (k == 0) {
                    System.out.print(list.get(k) + " ");
                } else {
                    System.out.print(list.get(k));
                }
            }
            System.out.println();
        }
    }
}
