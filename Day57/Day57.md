# 代码随想录算法训练营第五十七天
## [53. Treasure Hunt](https://kamacoder.com/problempage.php?pid=1053)

In a certain region of the world, there are several scattered mysterious islands. Each island contains a rare resource or treasure. The king plans to build roads between the islands to facilitate transportation.

The distances between different islands vary. The king wants you to design a road-building plan that **minimizes** the total distance required to connect all the islands (note: this is an **undirected graph problem**).

You are given a map that includes all the islands and the distances between them. Your task is to find the minimum total road length that ensures all islands are connected.

**Input Description**
The first line contains two integers `V` and `E`, where:

**V**: The number of vertices (islands), labeled from 1 to V.<br>
**E**: The number of edges (roads between islands).<br>
The next E lines each contain three integers v1, v2, and val, where:

**v1** and **v2**: The endpoints of an edge (road).<br>
**val**: The weight of the edge, representing the distance between the two islands.<br>
**Output Description**
Output the minimum total road length required to connect all islands.

**Example Input**
7 11 <br>
1 2 1<br>
1 3 1<br>
1 5 2<br>
2 6 1<br>
2 4 2<br>
2 3 2<br>
3 4 1<br>
4 5 1<br>
5 6 2<br>
5 7 1<br>
6 7 1

**Example Output:** 6

**Ideas:Prim**
A minimum spanning tree is a minimally connected subgraph of all nodes, i.e.: all nodes in the graph are linked together with minimum cost (weights of edges).There are `n` nodes in the graph, so it must be possible to 
link all nodes together with `n-1` edges.Then how to choose these n-1 edges is the task of the minimum spanning tree algorithm.

![image](https://github.com/user-attachments/assets/72521c61-1edf-48ec-aa34-a38a2521d155)

The prim algorithm uses a greedy strategy from the node's point of view to find the closest node to the minimum spanning tree each time and add it to the minimum spanning tree.<br>
The prim algorithm core trilogy:
1. Select the nearest node to the spanning tree
2. The nearest node is added to the spanning tree
3. Update the distance from the non-spanning tree nodes to the spanning tree (i.e., update the minDist array)
**The minDist array** is used to record the closest distance of each node from the minimum spanning tree.

**Initialize**
The values in the minDist array are initialised to the maximum number, because the node distances in this question won't be more than 10000, so initialising to the maximum number 10001 is fine.
![image](https://github.com/user-attachments/assets/c672be21-3b40-4312-bc5d-33c337155abe)

**Begin to build a minimum spanning tree**
1. Select the nearest node from the spanning tree

Select the nearest node from the minimum spanning tree, join the minimum spanning tree, at first there is no minimum spanning tree, so just choose a node to join (because each node will be in the minimum spanning 
tree, so just choose one), then we choose node 1 (in line with the habit of traversing the array, the first traversal of the first node 1)

2. The nearest node to join the spanning tree

At this point node 1 has been counted as the smallest spanning tree node.

3. Update the non-tree nodes to the spanning tree distance (that is, update the minDist array)

Next, we want to update the distance of all nodes from the minimum spanning tree, as shown:
![image](https://github.com/user-attachments/assets/91642251-91d7-4506-b6ac-fe588e3c4ff6)

![image](https://github.com/user-attachments/assets/6d55ba5a-9327-4eff-8f94-252ea12ce900)

![image](https://github.com/user-attachments/assets/88a3a440-028f-433e-9a8a-204f73c30338)

![image](https://github.com/user-attachments/assets/ba439082-dbff-48c3-b0eb-5a12c766f904)

```Java
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
```
**Ideas:Kruskal**
* Sort the edges by their weights, as the smallest edge is preferred to be added to the spanning tree
* Iterate over the sorted edges
If the first and last nodes of the edge are in the same set, show that a ring will appear in the graph if the edge is connected. <br>
If the first and last nodes of the edge are not in the same set, add to the minimum spanning tree and add both nodes to the same set.


![image](https://github.com/user-attachments/assets/72521c61-1edf-48ec-aa34-a38a2521d155)
The edges in the graph are sorted according to their weights from smallest to largest, so that from a greedy point of view, edges with small weights are preferred to be added to the minimum spanning tree. The order 
of the edges is [(1,2),(4,5),(1,3)(2,6)(3,4)(6,7)(5,7)(1,5)(3,2)(2,4)(5,6)] It does not matter the order of the edges with the same weights.
The points are then selected in order according to our ordering above, to first determine if the nodes are in a set, and if not you can add edges to the spanning tree.

```Java
class Edge {
    int l, r, val;

    public Edge(int l, int r, int val) {
        this.l = l;
        this.r = r;
        this.val = val;
    }
}

public class Kruskal {
    private static int n = 10001;
    private static int[] father = new int[n];
    
    public static void init(){
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }
    public static int find(int u){
        if(u == father[u]) return u;
        return father[u]= find(father[u]);
    }
    public static void join(int u, int v){
        u = find(u);
        v = find(v);
        if(u == v) return;
        father[v] = u;
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int v = myScanner.nextInt();
        int e = myScanner.nextInt();
        List<Edge> edges = new ArrayList<>();
        int result_val = 0;

        for (int i = 0; i < e; i++) {
            int v1 = myScanner.nextInt();
            int v2 = myScanner.nextInt();
            int val = myScanner.nextInt();
            edges.add(new Edge(v1,v2,val));
        }
        edges.sort(Comparator.comparingInt(edge-> edge.val));
        
        init();
        for(Edge edge : edges){
            int x = find(edge.l);
            int y = find(edge.r);
            if(x != y){
                result_val += edge.val;
                join(x,y);
            }
        }
        System.out.println(result_val);
        myScanner.close();
    }
}
```












