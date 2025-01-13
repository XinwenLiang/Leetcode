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

## [Intercity Cargo Transportation II](https://kamacoder.com/problempage.php?pid=1153)

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







































  
