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












































  
