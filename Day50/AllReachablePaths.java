package Day50;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AllReachablePaths {
    static List<List<Integer>> result = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();

    public static void dfs(int[][] graph, int x, int n) {
        if (x == n) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (graph[x][i] == 1) {
                path.add(i);
                dfs(graph, i, n);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int n = myScanner.nextInt();
        int m = myScanner.nextInt();

        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int s = myScanner.nextInt();
            int t = myScanner.nextInt();
            graph[s][t] = 1; // If s is connected to t, then make it equals to 1.
        }
        path.add(1);
        dfs(graph, 1, n);

        if (result.isEmpty()) System.out.println(-1);
        for (List<Integer> paths : result) {
            for (int i = 0; i < paths.size() - 1; i++) {
                System.out.println(paths.get(i) + " ");
            }
            System.out.println(paths.get(paths.size() - 1));
        }
    }
}
