# 代码随想录算法训练营第二十九天
## [134. Gas Station](https://leetcode.com/problems/gas-station/description/)

There are `n` gas stations along a circular route, where the amount of gas at the `ith` station is `gas[i]`.

You have a car with an unlimited gas tank and it costs `cost[i]` of gas to travel from the `ith` station to its next `(i + 1)th` station. You begin the journey with an empty tank at one of the gas stations.

Given two integer arrays `gas` and `cost`, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return `-1`. If there exists a solution, it is 
**guaranteed** to be **unique**.

**Example 1:**

**Input:** gas = [1,2,3,4,5], cost = [3,4,5,1,2] <br>
**Output:** 3<br>
**Explanation:** <br>
Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4 <br>
Travel to station 4. Your tank = 4 - 1 + 5 = 8<br>
Travel to station 0. Your tank = 8 - 2 + 1 = 7<br>
Travel to station 1. Your tank = 7 - 3 + 2 = 6<br>
Travel to station 2. Your tank = 6 - 4 + 3 = 5<br>
Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.<br>
Therefore, return 3 as the starting index.

**Ideas:** <br>
We can calculate the remaining fuel in the tank, and once it becomes negative, we choose the next station as our new starting point. Pruning: We can calculate the total remaining fuel, and if it is less than 0, it 
means it's impossible to complete a full loop starting from any station, so we return -1.

```Java
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost){
        int curSum = 0;
        int totalSum = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if(curSum < 0){
                start = i+1;
                curSum = 0;
            }
        }
        if(totalSum < 0) return -1;
        return start;
    }
}
```

## [135. Candy](https://leetcode.com/problems/candy/description/)

There are `n` children standing in a line. Each child is assigned a rating value given in the integer array `ratings`.

You are giving candies to these children subjected to the following requirements:
* Each child must have at least one candy.
* Children with a higher rating get more candies than their neighbors.
Return *the minimum number of candies you need to have to distribute the candies to the children*.

**Example 1:**

**Input:** ratings = [1,0,2] <br>
**Output:** 5 <br>
**Explanation:** You can allocate to the first, second and third child with 2, 1, 2 candies respectively.

**Ideas:** For this problem, we had better consiter two sides separately, which can make the problem become easier. If we join the two sides' logic together, we can easily be confused.
* If the right child did better than the left one: `if (ratings[i] > ratings[i-1])`, add one more candy to the right child:`Candy[i] = Candy[i-1] + 1`
* If the left child did better than the right one: `if (ratings[i] > ratings[i+1]`, add one more candy to the left child and compare it with the first case: `Candy[i] = Math.max(Candy[i+1]+1, Candy[i])`

```Java
public class Candy {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] Candy = new int[len];
        Candy[0] = 1;
        for (int i = 1; i < len; i++) {
            if(ratings[i] > ratings[i-1]){
                Candy[i] = Candy[i-1] + 1;
            }else{
                Candy[i] = 1;
            }
        }
        for (int i = len - 2; i >= 0 ; i--) {
            if(ratings[i] > ratings[i+1]){
                Candy[i] = Math.max(Candy[i+1] + 1, Candy[i]);
            }
        }
        int result = 0;
        for (int i = 0; i < len; i++) {
            result += Candy[i];
        }
        return result;
    }
}
```

## [860. Lemonade Change](https://leetcode.com/problems/lemonade-change/description/)

At a lemonade stand, each lemonade costs `$5`. Customers are standing in a queue to buy from you and order one at a time (in the order specified by bills). Each customer will only buy one lemonade and pay with either a `$5`, `$10`, or `$20` bill. You must provide the correct change to each customer so that the net transaction is that the customer pays `$5`.

Note that you do not have any change in hand at first.

Given an integer array `bills` where `bills[i]` is the bill the `ith` customer pays, return `true` if you can provide every customer with the correct change, or `false` otherwise.

**Example 1:**

**Input:** bills = [5,5,5,10,20] <br>
**Output:** true <br>
**Explanation:** <br> 
From the first 3 customers, we collect three $5 bills in order. <br>
From the fourth customer, we collect a $10 bill and give back a $5.<br>
From the fifth customer, we give a $10 bill and a $5 bill.<br>
Since all customers got correct change, we output true.<br>

**Ideas:** <br>
There are three cases:
* $5: No need to change.
* $10: change `$5`
* $20: Two methods: Greedy methods: prefer `$10 + $5` to 3 `$5'`s.

```Java
public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        int twenty = 0;
        for (int bill : bills) {
            if (bill == 5) five++;
            if (bill == 10) {
                if (five == 0) return false;
                else {
                    ten++;
                    five--;
                }
            }
            if (bill == 20) {
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                    twenty++;
                } else if (five >= 3) {
                    five -= 3;
                    twenty++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
```

## [406. Queue Reconstruction by Height](https://leetcode.com/problems/queue-reconstruction-by-height/description/)

You are given an array of people, `people`, which are the attributes of some people in a queue (not necessarily in order). Each `people[i] = [hi, ki]` represents the `ith` person of height `hi` with **exactly** `ki` 
other people in front who have a height greater than or equal to `hi`.

Reconstruct and return *the queue that is represented by the input array* `people`. The returned queue should be formatted as an array `queue`, where `queue[j] = [hj, kj]` is the attributes of the `jth` person in the 
queue (`queue[0]` is the person at the front of the queue).

**Example 1:**

**Input:** people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]] <br>
**Output:** [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] <br>
**Explanation:** <br>
Person 0 has height 5 with no other people taller or the same height in front.<br>
Person 1 has height 7 with no other people taller or the same height in front.<br>
Person 2 has height 5 with two persons taller or the same height in front, which is person 0 and 1.<br>
Person 3 has height 6 with one person taller or the same height in front, which is person 1.<br>
Person 4 has height 4 with four people taller or the same height in front, which are people 0, 1, 2, and 3.<br>
Person 5 has height 7 with one person taller or the same height in front, which is person 1.<br>
Hence [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] is the reconstructed queue.

**Ideas:** First, sort by height in descending order, then adjust their positions based on the value of `k`.

```Java
public class QueueHeight {
    LinkedList<int[]> res = new LinkedList<>();
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a,b) -> {
            if(a[0] == b[0]) return a[1] - b[1]; // If their heights are equal, sort them in ascending order based on k value.
            return b[0] - a[0]; // Otherwise, sort them in descending order based on height.
        });

        for(int[] p : people){
            res.add(p[1],p);
        }
        return res.toArray(new int[people.length][]);
    }
}
```





















