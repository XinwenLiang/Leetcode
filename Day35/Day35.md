# 代码随想录算法训练营第三十五天
## 0-1 Knapsack Problem

You are given `n` items and a backpack that can carry a maximum weight of `w`. Each item `i` has a weight of `weight[i]` and a value of `value[i]`. Each item can be used **only once**. The goal is to determine which 
items to include in the backpack such that the total value of the selected items is **maximized**.

**Ideas:**
1. Define the dp Array and Its Index Meaning
  The definition of `dp[i][j]` is: the maximum value that can be achieved by selecting items from the range (0, i) to place in a backpack with capacity j.
* Not placing item i: The value remains dp[i-1][j].
* Placing item i: The value is dp[i-1][j-weight[i]] + value[i].
2. Determine the Recurrence Relation (State Transition Equation)
  Since we want to maximize the total value of the backpack within its capacity, we take the maximum of the two cases. The recurrence relation is:
  `dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]] + value[i])`
4. Initialize the dp Array
* For the first column (`dp[i][0]`), the backpack capacity is 0, so no items can be placed, and the value is always 0.
* For the first row (dp[0][j]), where i = 0 (considering only the 0th item):
If j < weight[0], then dp[0][j] = 0 because the backpack's capacity is less than the weight of the 0th item.<br>
If j >= weight[0], then dp[0][j] = \text{value}[0] because the backpack has enough capacity to hold the 0th item.
5. Determine the Traversal Order
  We can process either by iterating over the backpack capacity first and then the items, or by iterating over the items first and then the backpack capacity. Both approaches work.

```Java
public class Knapsack1 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int n = myScanner.nextInt();
        int bagWeight = myScanner.nextInt();

        int[] weight = new int[n];
        int[] value = new int[n];

        for (int i = 0; i < n; i++) {
            weight[i] = myScanner.nextInt();
        }
        for (int j = 0; j < n; j++) {
            value[j] = myScanner.nextInt();
        }
        int[][] dp = new int[n][bagWeight + 1];

        // Initialize the dp array.
        for (int j = weight[0]; j <= bagWeight; j++) {
            dp[0][j] = value[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= bagWeight; j++) {
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        System.out.println(dp[n - 1][bagWeight]);
    }
}
```

## 0-1 Knapsack Problem (one-dimention dp array)

You are given `n` items and a backpack that can carry a maximum weight of `w`. Each item `i` has a weight of `weight[i]` and a value of `value[i]`. Each item can be used **only once**. The goal is to determine which 
items to include in the backpack such that the total value of the selected items is **maximized**.

**Ideas:**
1. Define the dp Array and Its Index Meaning
  The definition of `dp[j]` is: the maximum value that can be achieved by selecting items from the range (0, i) to place in a backpack with capacity j.
* Not placing item i: The value remains dp[j].
* Placing item i: The value is dp[j-weight[i]] + value[i].
2. Determine the Recurrence Relation (State Transition Equation)
  Since we want to maximize the total value of the backpack within its capacity, we take the maximum of the two cases. The recurrence relation is:
  `dp[i][j] = Math.max(dp[j], dp[j-weight[i]] + value[i])`
4. Initialize the dp Array
   dp[j] = 0, when the capacity of bag is 0, the maximal value of this bag is 0 too.
5. Determine the Traversal Order
  We can only use reverse iteration to ensure that each item is used only once.

  ```Java
  public class Knapsack2 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int n = myScanner.nextInt();
        int bagWeight = myScanner.nextInt();

        int[] weight = new int[n];
        int[] value = new int[n];

        for (int i = 0; i < n; i++) {
            weight[i] = myScanner.nextInt();
        }
        for (int j = 0; j < n; j++) {
            value[j] = myScanner.nextInt();
        }
        int[] dp = new int[bagWeight + 1];

        // Initialize the dp array.
        dp[0] = 0;

        for (int i = 1; i < n ; i++) {
            for (int j = bagWeight; j >= weight[i] ; j--) {
                dp[j] = Math.max(dp[j],dp[j-weight[i]] + value[i]);
            }
        }
        System.out.println(dp[bagWeight]);
    }
}
```

## 























