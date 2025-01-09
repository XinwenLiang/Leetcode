# 代码随想录算法训练营第五十八天
## [117. Software Build](https://kamacoder.com/problempage.php?pid=1191)

**Problem Description** <br>
A large software project consists of `N` files, numbered from 0 to `N - 1`. Some files depend on others, meaning that if file `A` depends on file `B`, then file B must be processed before file `A` (0 <= A, B <= N - 1). Write an algorithm to determine a valid order in which the files can be processed.

**Input Description**
* The first line contains two positive integers N and M, where N represents the number of files and M represents the number of dependency relations between the files.
* The next M lines each contain two integers S and T, indicating that file T depends on file S.

**Output Description**
* Output a single line. If a valid processing order exists, print the file order separated by spaces.
* If no valid order exists due to cyclic dependencies, output -1.

**Sample Input**
5 4 <br>
0 1 <br>
0 2 <br>
1 3 <br>
2 4

**Sample Output**
0 1 2 3 4

**Explanation** <br>
The file dependency relations are as follows:

![image](https://github.com/user-attachments/assets/0caede29-a7b1-4ecd-b305-3e7fccb5fb64)

* File 1 depends on file 0.
* File 2 depends on file 0.
* File 3 depends on file 1.
* File 4 depends on file 2.
  Therefore, a valid processing order is 0 1 2 3 4, though other valid orders such as 0 2 4 1 3 or 0 2 1 3 4 are also possible.

If there is a cycle in the dependency graph (i.e., circular dependencies between files), the output should be -1.

**Ideas:**
Given a directed graph, converting this directed graph into a linear order is called **topological sorting**. At the same time, topological sorting also needs to check whether the directed graph contains a cycle, i.e., if there are circular dependencies. If such a cycle exists, linear ordering cannot be performed. Therefore, topological sorting is a common method in graph theory to determine whether a graph is a Directed Acyclic Graph (DAG).

**BFS Algorithm for Topological Sorting:**
* Find all nodes with an in-degree of 0 and add them to the result set.
* Remove these nodes from the graph.
* If the number of elements in the result set is not equal to the total number of nodes in the graph, it indicates that there is a cycle in the graph.

```Java
public class TopologicalSort {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int n = myScanner.nextInt();
        int m = myScanner.nextInt();

        List<List<Integer>> uMap = new ArrayList<>();
        int[] inDegree = new int[n];

        for (int i = 0; i < n; i++) {
            uMap.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int s = myScanner.nextInt();
            int t = myScanner.nextInt();
            uMap.get(s).add(t);
            inDegree[t]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            result.add(cur);
            for (int file : uMap.get(cur)) {
                inDegree[file]--;
                if (inDegree[file] == 0) {
                    queue.add(file);
                }
            }
        }
        if (result.size() == n) {
            for (int i = 0; i < result.size(); i++) {
                System.out.println(result.get(i));
                if (i < result.size() - 1) {
                    System.out.println(" ");
                }
            }
        } else {
            System.out.println(-1);
        }
    }
}
```

## [47.Attending a Scientific Conference](https://kamacoder.com/problempage.php?pid=1047)
**Problem Description**
Xiao Ming is a scientist who needs to attend an important international scientific conference to present his latest research.

His starting point is the first bus station, and his destination is the last bus station. However, the road conditions, traffic congestion, and potential natural factors (such as weather changes) between stations can vary, affecting the travel time on each route.

Xiao Ming wants to choose a route that minimizes his travel time so he can reach the destination as quickly as possible.

**Input Description**
* The first line contains two positive integers:
    1. N: the total number of bus stations.
    2. M: the total number of roads.
       The next M lines each contain three integers S, E, and V, representing a one-way road from station S to station E with a travel time of V units.

**Output Description**
Output a single integer, representing the minimum time required for Xiao Ming to travel from the starting station to the destination station. <br>
If it is impossible to reach the destination, output -1.

**Sample Input**
7 9 <br>
1 2 1<br>
1 3 4<br>
2 3 2<br>
2 4 5<br>
3 4 2<br>
4 5 3<br>
2 6 4<br>
5 7 4<br>
6 7 9

**Sample Output** 12

**Explanation**
* Reachable Case
  In the given example, the shortest path from station 1 to station 7 is shown in green in the diagram (if visualized). The total length of the shortest route is 12, so the output is 12.
  ![image](https://github.com/user-attachments/assets/f9bd7c97-e1ab-44b3-b2c8-2bdf4ade893c)
* Unreachable Case
  If it is impossible to reach the destination from the starting station (e.g., there are no connecting paths), output -1.
  ![image](https://github.com/user-attachments/assets/5d91a4c9-1dd9-4b1e-82d3-ca9e031dffe4)

**Ideas:**
**Dijkstra Algorithm:** <br>
An algorithm for finding the shortest path from a starting node to all other nodes in a weighted graph.

**Three Steps of Dijkstra's Algorithm:**
1. Select the nearest unvisited node from the source node.
2. Mark the selected node as visited.
3. Update the distances of unvisited nodes from the source node (i.e., update the minDist array).
   We use the minDist array to keep track of the minimum distance from the source node to each node. Below is the simulation process.

1. Initialize:
   ![image](https://github.com/user-attachments/assets/4dae0043-e7e3-46bd-97d8-9ccffae2ff21)

2. Choose node 1.
   ![image](https://github.com/user-attachments/assets/69349a8f-02eb-42f6-a5ad-3100541d4112)

3. Choose node 2.
   ![image](https://github.com/user-attachments/assets/296e594b-7cd3-43fb-af21-f514f585beb3)

4. Choose node 3.
   ![image](https://github.com/user-attachments/assets/5ea9a742-03df-4312-bbc7-82ffae216451)

5. Choose node 4.
   ![image](https://github.com/user-attachments/assets/a1d2c5c9-a530-4691-b108-88e36d1f9b08)

6. Choose node 5.
   ![image](https://github.com/user-attachments/assets/de09b5c3-cdd8-441e-8c5d-cbe5bc9144ca)

```Java













   
