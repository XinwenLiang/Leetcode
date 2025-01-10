# 代码随想录算法训练营第五十九天
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

**Use stack to optimize the algorithm**
The approach is essentially still the three-step process of Dijkstra's algorithm. Previously, we traversed edges by iterating over nodes, using a nested loop to find the node closest to the source.
This time, we directly traverse the edges and use a heap to sort them, allowing us to directly select the edge with the smallest distance from the source. Since we want to choose the node closest to the source (i.e., the edge with the smallest weight), we need a min-heap to help sort the edges by weight. Each time, we can retrieve the edge with the smallest weight from the top of the min-heap.

```Java
public class DijkstraII {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int n = myScanner.nextInt();
        int m = myScanner.nextInt();

        List<List<Edge>> grid = new ArrayList<>(n+1);
        for (int i = 0; i <= n; i++) {
            grid.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int p1 = myScanner.nextInt();
            int p2 = myScanner.nextInt();
            int val = myScanner.nextInt();
            grid.get(p1).add(new Edge(p2, val));
        }

        int start = 1;
        int end = n;

        int[] minDist = new int[n+1];
        Arrays.fill(minDist, Integer.MAX_VALUE);

        boolean[] visited = new boolean[n+1];

        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(new MyComparison());

        pq.add(new Pair<>(start,0));
        minDist[start] = 0;
        while(!pq.isEmpty()){
            Pair<Integer,Integer> cur = pq.poll();
            if(visited[cur.first]) continue;

            visited[cur.first] = true;

            for(Edge edge : grid.get(cur.first));
        }
    }

}
class Edge{
    int to;
    int val;

    Edge(int to, int val){
        this.to = to;
        this.val = val;
    }
}
class MyComparison implements Comparator<Pair<Integer,Integer>>{
    @Override
    public int compare(Pair<Integer,Integer> lhs, Pair<Integer,Integer> rhs){
        return Integer.compare(lhs.second, rhs.second);
    }
}
class Pair<U,V>{
    public final U first;
    public final V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
}
```

## [Cargo Transportation Between Cities I](https://kamacoder.com/problempage.php?pid=1152)
To promote economic exchange between cities, a country has decided to subsidize cargo transportation. 
There are `n` cities numbered from 1 to n, connected by a road network. Each road in the network only allows one-way traffic from one city to another, with no reverse travel allowed.

Each road has a transportation cost and a government subsidy. The weight of a road is calculated as:
`road weight = transportation cost - government subsidy`.
* A **positive weight** means that after deducting the government subsidy, transporting goods still incurs a cost.
* A **negative weight** means that the government subsidy exceeds the transportation cost, resulting in a profit during the transportation process.
Your task is to find the path with the lowest transportation cost, considering the subsidies, among all possible paths from city 1 to city n.
If the minimum transportation cost is a negative number, it indicates that a profit can be achieved by following the optimal path.

Note that it is possible for there to be no path between city 1 and city n. Additionally, it is guaranteed that there are no negative weight cycles in the road network.

**Input Description**
The first line contains two positive integers:
* n: The total number of cities.
* m: The total number of roads connecting these cities.
The following m lines each contain three integers s, t, and v, representing:
* s: The starting city.
* t: The destination city.
* v: The weight of the road from city s to city t (one-way).
**Output Description**
* If there exists a path from city 1 to city n, output an integer representing the minimum transportation cost. If the result is negative, it indicates that profit can be achieved.
* If there is no path from city 1 to city n, output "unconnected".
**Example Input**
6 7<br>
5 6 -2<br>
1 2 1<br>
5 3 1<br>
2 5 2<br>
2 4 -3<br>
4 6 4<br>
1 3 5
  
**Example Output:** 1

  ![image](https://github.com/user-attachments/assets/db21450a-5016-4705-ae6a-d10c5c7a0c33)

**Ideas:**
**Bellman_ford Algorithm**
If a shorter path to node B is available through the edge A to B, i.e. if `minDist[B] > minDist[A] + value` then we update `minDist[B] = minDist[A] + value`.

**Mock process**
1. Initialize.
   ![image](https://github.com/user-attachments/assets/b7268353-37ca-4971-8f42-d07ddddeab79)
2. Update 2
   ![image](https://github.com/user-attachments/assets/0c9ff626-26fe-4134-8255-f4c09a5d31ff)
3. Update 5
   ![image](https://github.com/user-attachments/assets/02d02253-ac12-453a-b934-aaa19ea62371)
4. Update 4
   ![image](https://github.com/user-attachments/assets/9f4fba20-b1f1-4abe-a539-e37f1baa1419)
5. Update 5
   ![image](https://github.com/user-attachments/assets/0a770092-11d7-4a7c-81c2-5e6cba33b41f)
6. Update 3
   ![image](https://github.com/user-attachments/assets/69ca3a3b-9bdf-4046-99f5-dec0625dbe7f)
The core algorithm involves performing n-1 **relaxations** on all edges.

```Java
public class BellmanI {
    static class Edge {
        int from;
        int to;
        int val;

        public Edge(int from, int to, int val) {
            this.from = from;
            this.to = to;
            this.val = val;
        }

        public static void main(String[] args) {
            Scanner myScanner = new Scanner(System.in);
            int n = myScanner.nextInt();
            int m = myScanner.nextInt();
            List<Edge> edges = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                int from = myScanner.nextInt();
                int to = myScanner.nextInt();
                int val = myScanner.nextInt();
                edges.add(new Edge(from, to, val));
            }

            // Initialise the minDist array.
            int[] minDist = new int[n + 1];
            Arrays.fill(minDist, Integer.MAX_VALUE);
            minDist[1] = 0;

            for (int i = 1; i < n; i++) {
                for (Edge edge : edges) {
                    // Update the minDist Array.
                    if (minDist[edge.from] != Integer.MAX_VALUE) {
                        System.out.println("unconnected");
                    } else {
                        System.out.println(minDist[n]);
                    }
                }
            }
        }
    }
}
```






























