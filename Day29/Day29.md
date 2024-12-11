# 代码随想录算法训练营
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






























