package Day58;

import java.util.Arrays;
import java.util.Scanner;

public class Dijkstra {
    public static void main(String[] args) {
        Scanner myScanner =  new Scanner(System.in);
        int n = myScanner.nextInt();
        int m = myScanner.nextInt();

        int[][] grid = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(grid[i],Integer.MAX_VALUE);
        }
        for (int i = 0; i < m; i++) {
            int p1 = myScanner.nextInt();
            int p2 = myScanner.nextInt();
            int val = myScanner.nextInt();
            grid[p1][p2] = val;
        }
        int start = 1;
        int end = n;

        // Store the shorted distance from the start to each node.
        int[] minDist = new int[n+1];
        Arrays.fill(minDist,Integer.MAX_VALUE);

        boolean[] visited = new boolean[n+1];
        minDist[start] = 0;

        for (int i = 1; i <= n; i++) {
            int minVal = Integer.MAX_VALUE;
            int cur = 1;

            for (int v = 1; v <=n ; ++v) {
                if(! visited[v] && minDist[v] < minVal){
                    minVal = minDist[v];
                    cur = v;
                }
            }
        }
        if(minDist[end] == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(minDist[end]);
        }
    }
}
