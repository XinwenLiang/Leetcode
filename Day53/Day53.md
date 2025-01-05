# 代码随想录算法训练营第五十三天
## [110. Word Ladder](https://kamacoder.com/problempage.php?pid=1183)

Given a list of strings strList (a dictionary) and two strings beginStr and endStr, your task is to find the shortest transformation sequence from beginStr to endStr.

**Transformation Rules:**
1. The first string in the sequence must be beginStr.
2. The last string in the sequence must be endStr.
3. Only one character can be changed at a time during the transformation, and each intermediate string in the sequence must exist in the dictionary strList.
4. If no such transformation sequence exists, return 0.

**Input Description**
* The first line contains an integer N, representing the number of strings in the dictionary strList.
* The second line contains two space-separated strings: beginStr and endStr.
* The following N lines each contain one string, representing the strings in the dictionary.

**Output Description**
Output an integer representing the number of strings in the shortest transformation sequence from beginStr to endStr. If no such sequence exists, output 0.

**Example1:**

**Input**
6 <br>
abc def <br>
efc <br>
dbc <br>
ebc <br>
dec <br>
dfc <br>
yhn 

**Output** 4
![image](https://github.com/user-attachments/assets/a8ab10ca-7f7c-4f9e-84f2-068085adbfa4)

**Ideas:**
First, if two points differ by only one character, it means there is a link between them. This problem is well-suited for breadth-first search (BFS) because BFS guarantees the shortest path once the endpoint is 
reached. Additionally, we need a marker to track the nodes we have visited to avoid falling into infinite loops.

```Java
public class WordLadder {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int n = myScanner.nextInt();
        myScanner.nextLine();
        String beginStr = myScanner.next();
        String endStr = myScanner.next();
        myScanner.nextLine();
        List<String> wordList = new ArrayList<>();
        wordList.add(beginStr);
        wordList.add(endStr);
        for (int i = 0; i < n; i++) {
            wordList.add(myScanner.nextLine());
        }
        int count = bfs(beginStr, endStr, wordList);
        System.out.println(count);
    }

    public static int bfs(String beginStr, String endStr, List<String> wordList) {
        int len = 1; // Keep track of the current length of the transformation sequence.
        Set<String> set = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        visited.add(beginStr);
        queue.add(beginStr);
        queue.add(null);
        while (!queue.isEmpty()) {
            String node = queue.remove();
            if (node == null) {
                if (!queue.isEmpty()) {
                    len++;
                    queue.add(null);
                }
                continue;
            }
            char[] charArray = node.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                char old = charArray[i];
                for (char j = 'a'; j <= 'z'; j++) {
                    charArray[i] = j;
                    String newWord = new String(charArray);
                    if (set.contains(newWord) && !visited.contains(newWord)) {
                        queue.add(newWord);
                        visited.add(newWord);
                        // Found the end.
                        if (newWord.equals(endStr)) return len + 1;
                    }
                }
                charArray[i] = old;
            }
        }
        return 0;
    }
}
```

## [105.Complete Reachability in a Directed Graph](https://kamacoder.com/problempage.php?pid=1177)

Given a directed graph with N nodes numbered from **1** to **N**, determine if it's possible to reach every node starting from node **1** by following the directed edges. If all nodes can be reached from node 1, 
output `1`; otherwise, output `-1`.

**Input Description**
* The first line contains two positive integers N and K, representing the number of nodes and the number of edges, respectively.
* The next K lines each contain two positive integers s and t, indicating a directed edge from node s to node t.
**Output Description**
Output 1 if it is possible to reach every node starting from node 1. Otherwise, output -1.

**Example1:**

**Input**
4 4 <br>
1 2 <br>
2 1 <br>
1 3 <br>
2 4 

**Output:** 1


**Ideas:**
This problem involves finding all reachable paths in a directed graph. We can solve it using depth-first search (DFS). Here's a step-by-step explanation:

1. Define the recursive function:
The function should take the graph as a parameter and track the current key (node) to determine the next room (node) to visit.
Additionally, we need an array to record which rooms (nodes) have been visited. This array will help us determine whether all rooms have been traversed by the end. We can use a one-dimensional boolean array for this
purpose.

2.Set the termination condition:
Use the visited array to record the nodes that have been visited. Initially, all elements in the array are set to false. Mark an element as true once its corresponding node has been processed.
If the current node being processed is already marked as true in the visited array, it means the node has already been visited, so we terminate the current recursion. If it hasn’t been visited, we mark it as true 
since we are now processing this node.

3.Handle paths originating from the current node:
For each node, we recursively explore all its outgoing paths. Since this problem only requires determining whether there is a path from node 1 to all other nodes, we don’t need to implement backtracking. Once a node 
is visited, we move forward without revisiting it.

```Java
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
```

## [106.Perimeter of the Island](https://kamacoder.com/problempage.php?pid=1178)

Given a matrix composed of 1s (land) and 0s (water). An island is formed by connecting adjacent pieces of land in horizontal or vertical directions and is completely surrounded by water.

You can assume that the area outside the matrix is entirely water. The matrix contains exactly one island (a single connected component of land), and each piece of land has an edge length of 1. Your task is to 
calculate the perimeter of the island. There are no bodies of water inside the island.

**Input Description**
* The first line contains two integers N and M, representing the number of rows and columns in the matrix.
* The next N lines contain M integers (1 or 0), where:
1 represents land. <br>
0 represents water. <br>
**Output Description**
Output a single integer, representing the perimeter of the island.

**Example1:**

**Input:**
5 5 <br>
0 0 0 0 0 <br>
0 1 0 1 0 <br>
0 1 1 1 0 <br>
0 1 1 1 0 <br>
0 0 0 0 0 

**Output**
14
![image](https://github.com/user-attachments/assets/7d8c0f5f-9413-487f-82d9-5fc810739b48)

**Ideas:** <br>
Traverse each cell in the matrix, and when a piece of land is encountered, check the cells above, below, to the left, and to the right of it.

* If the adjacent cell contains water, it means there is an exposed edge. For example, if the cell to the right of the land contains water, it counts as an edge.
* If any of the adjacent cells are out of bounds, it also counts as an edge.

```Java
public class PerimeterOfIsland {
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int count;

    public static void helper(int[][] grid, int x, int y) {
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];

            // when meet the border or water, add 1 to the perimeter.
            if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length
                    || grid[nx][ny] == 0) {
                count++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int result = 0; // 总周长
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count = 0;
                    helper(grid, i, j);
                    // update the new perimeter.
                    result += count;
                }
            }
        }
        
        System.out.println(result);
    }
}
```




























