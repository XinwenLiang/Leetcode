package Day57;

import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.util.Arrays;
import java.util.Scanner;

public class prim {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int v = myScanner.nextInt();
        int e = myScanner.nextInt();

        // Initialise the adjacency matrix.
        int[][] grid = new int[v+1][v+1];
        for (int i = 0; i < v+1; i++) {
            Arrays.fill(grid[i],10001);
        }

        for (int i = 0; i < e; i++) {
            int x = myScanner.nextInt();
            int y = myScanner.nextInt();
            int z = myScanner.nextInt();
            grid[x][y] = z;
            grid[y][x] = z;
        }
        int[] minDist = new int[v+1];
        Arrays.fill(minDist, 10001);
        boolean[] isInTree = new boolean[v+1];
        for (int i = 1; i < v; i++) {
            int cur = -1;
            int minVal = Integer.MAX_VALUE;

            for (int j = 1; j <=v ; j++) {
                if(!isInTree[j] && minDist[j] < minVal){
                    minVal = minDist[j];
                    cur = j;
                }
            }
            // Add the nearest node to the spanning tree.
            isInTree[cur] = true;
            // Update the distance between nodes.
            for (int j = 1; j <=v ; j++) {
                if(!isInTree[j] && grid[cur][j] < minDist[j]){
                    minDist[j] = grid[cur][j];
                }
            }
        }
        int result = 0;
        for (int i = 2; i <= v ; i++) {
            result += minDist[i];
        }
        System.out.println(result);
        myScanner.close();
    }
}
