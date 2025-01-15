# 代码随想录算法训练营第六十天
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

**SPFA Ideas** 
We can add nodes to the queue one by one and then perform relaxation by dequeuing the front element. An optimization can be applied during the enqueueing process: use a `visited` array to record elements that are 
already in the queue, so we don't enqueue the same element multiple times.

## [95. Intercity Cargo Transportation II](https://kamacoder.com/problempage.php?pid=1153)

**Problem Description**
A certain country wants to promote economic exchange between cities and has decided to subsidize cargo transportation. There are n cities numbered from 1 to n, connected by a road network. Each road allows one-way 
traffic from one city to another; reverse travel is not allowed.

Each road has its own transportation cost and government subsidy. The weight of a road is calculated as:
`weight = transportation cost - government subsidy`.

* If the weight is **positive**, it means that even after deducting the subsidy, there is still a cost to transport goods.
* If the weight is **negative**, it means that the government subsidy exceeds the transportation cost, resulting in a net profit during transportation.
When evaluating the minimum total transportation cost from city 1 to city n, taking into account all government subsidies, a special situation may arise: the graph may contain a negative-weight cycle.
A negative-weight cycle is a series of roads where the total weight is negative. By repeatedly traveling through this cycle, the total cost can theoretically be reduced infinitely, or the total profit can be
increased infinitely. To prevent transporters from exploiting negative-weight cycles to earn unlimited subsidies, the algorithm must detect and handle such cycles properly.

**Task**
Find the minimum transportation cost from city 1 to city n, including the effect of government subsidies. Additionally, the algorithm must be able to detect and handle negative-weight cycles correctly.

* If no negative-weight cycle is detected, output an integer representing the minimum transportation cost from city 1 to city n (including subsidies).
If this integer is negative, it indicates a net profit.
* If a negative-weight cycle is detected, output `"circle"`.
* If there is no path from city 1 to city n, output `"unconnected"`.

**Input Description**
The first line contains two positive integers:

* n: the number of cities (1 ≤ n ≤ 1000)
* m: the number of roads (1 ≤ m ≤ 10000)
The next m lines each contain three integers s, t, and v:

* s: the starting city of the road
* t: the destination city of the road
* v: the weight of the road from s to t.

**Output Description**
* If no negative-weight cycle is detected, output the minimum transportation cost from city 1 to city n. This value may be negative, indicating a net profit.
* If a negative-weight cycle is detected, output "circle".
* If there is no path from city 1 to city n, output "unconnected".

**Sample Input**
4 4 <br>  
1 2 -1  <br>
2 3 1  <br>
3 1 -1  <br>
3 4 1 

**Sample Output** circle

**Ideas:**
Let's loosen it up one more time on top of the original and see what happens.

```Java
public class SPFAII {
    static class Edge{
        int from;
        int to;
        int val;

        public Edge(int from, int to, int val) {
            this.from = from;
            this.to = to;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int n = myScanner.nextInt();
        int m = myScanner.nextInt();
        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int from = myScanner.nextInt();
            int to = myScanner.nextInt();
            int val = myScanner.nextInt();
            graph.get(from).add(new Edge(from, to, val));
        }

        int[] minDist = new int[n+1];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[1] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        int[] count = new int[n+1];
        count[1] ++;

        boolean[] isInQueue = new boolean[n+1];
        boolean flag = false;

        while(!queue.isEmpty()){
            int curNode = queue.poll();
            isInQueue[curNode] = false;
            for(Edge edge: graph.get(curNode)){
                if(minDist[edge.to] > minDist[edge.from] + edge.val){
                    minDist[edge.to] = minDist[edge.from] + edge.val;
                    if(! isInQueue[edge.to]){
                        queue.offer(edge.to);
                        count[edge.to] ++;
                        isInQueue[edge.to] = true;
                    }

                    if(count[edge.to] == n){
                        flag = true;
                        while(!queue.isEmpty()) queue.poll();
                        break;
                    }
                }
            }
        }
        if(flag){
            System.out.println("circle");
        }else if(minDist[n] == Integer.MAX_VALUE){
            System.out.println("unconnected");
        }else{
            System.out.println(minDist[n]);
        }
    }
}
```

## [96.Intercity Cargo Transportation III](https://kamacoder.com/problempage.php?pid=1154)
A country has decided to subsidise the transport of goods in order to promote economic exchanges between cities. There are `n` cities, numbered `1` to `n`, connected by a network of roads that allow one-way traffic 
only from one city to another, not in the opposite direction.

Each road in the network has its own transport cost and government subsidy, and the weights of the roads are calculated as: `transport cost - government subsidy`.
* A positive weight indicates the cost of transporting the goods after deducting the government subsidy;
* A negative weighting means that the government subsidy exceeds the cost of transport, which in reality means that a certain amount of revenue is earned during the transport.

Calculate the minimum cost of transporting the goods from city src to city dst if at most `k` cities are passed through.

**Input Description**

The first line contains two positive integers, the first positive integer n means that there are n cities in the country, and the second integer m means that there are m roads in these cities.

The second integer, m, indicates that there are m roads in these cities. The next m rows, each containing three integers, s, t, and v, indicate that city s is transporting goods to city t, and the weight of the road 
is v. The last row contains three positive integers, s, t, and v.

The last line contains three positive integers, src, dst, and k. src and dst are the city numbers, and there is a limit on the number of cities passing from src to dst.

**Output Description**

Output an integer indicating the minimum transport cost from city src to city dst. If the path from src to dst cannot be found within the given number of cities passed through, output ‘unreachable’, indicating that 
there is no eligible transport solution.




































  
