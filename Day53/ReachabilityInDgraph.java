package Day53;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReachabilityInDgraph {
    public static void dfs(List<List<Integer>> graph, int node, boolean[] visited){
        if(visited[node]){
            return;
        }
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            dfs(graph, neighbor, visited);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // The number of nodes.
        int m = scanner.nextInt();  // The number of edges.


        List<List<Integer>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }


        for (int i = 0; i < m; i++) {
            int s = scanner.nextInt();
            int t = scanner.nextInt();
            graph.get(s).add(t);
        }

        boolean[] visited = new boolean[n + 1];
        dfs(graph, 1, visited);

        // Check if all the nodes are searched.
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(1);
    }
}
