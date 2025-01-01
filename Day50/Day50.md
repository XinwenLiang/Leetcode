# 代码随想录算法训练营第五十天
## [98. All Reachable Paths](https://kamacoder.com/problempage.php?pid=1170)

Given a directed graph with n nodes (nodes are numbered from 1 to n), write a function to find and return all paths from node 1 to node n. Each path should be represented as a sequence of node numbers.

**Input Description**
* The first line contains two integers `N` and `M, representing the number of nodes and edges in the graph.
* The following M lines each contain two integers s and t, indicating that there is a directed edge from node s to node t.

**Output Description**
* Output all reachable paths. Each path occupies a separate line, with nodes in the path separated by a single space.
* If multiple paths exist, their order in the output can be arbitrary.
* If no path exists from node 1 to node n, output -1.
* **Note:** Ensure there is no extra space at the end of each line. For example, a correct output is 1 3 5 and not 1 3 5 .

**Example1**

**Input:** 
5 5<br>
1 3<br>
3 5<br>
1 2<br>
2 4<br>
4 5<br>
**Output**
1 3 5 <br>
1 2 4 5

**Ideas:**
1. Confirm the DFS Function and Parameters
* First, our dfs function must maintain a graph to traverse. It also needs to store the currently visited node, defined as x.
* Additionally, we need a parameter n to represent the destination node. During traversal, we use x == n to indicate that the destination has been reached.
2. Confirm the Termination Condition
* The termination condition is when the currently visited node is the destination node n. At this point, we have found a path from the starting point to the destination.
3. Handle Paths Starting from the Current Node
* Next, explore the paths from the current node x to its next connected nodes.
* Then, add the node pointed to by x into the current path.
* Then, enter the next level of recursion.
* Finally, during backtracking, undo the operation of adding the current node to the path.

```Java
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
```









































