# 代码随想录算法训练营第二十二天
## [77. Combinations](https://leetcode.com/problems/combinations/description/)

Given two integers `n` and `k`, return all possible combinations of `k` numbers chosen from the range `[1, n]`.

You may return the answer **in any order**.

 

**Example 1:**

**Input:** n = 4, k = 2<br>
**Output:** [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]] <br>
**Explanation:** There are 4 choose 2 = 6 total combinations.<br>
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.

**Ideas:** We can consider combinations as the leaves in a tree strcuture. Each time an element is selected from the set, the range of selectable elements shrinks as the selection 
progresses, adjusting the available range accordingly. In the diagram, it can be observed that `n` corresponds to the width of the tree, while `k` corresponds to the depth of the tree.
So how can we traverse this tree and collect the desired result set?
In the diagram, each time a leaf node is reached during the search, a result is found.
This means that we only need to collect the results obtained at the leaf nodes to compute the combination set of `k` numbers chosen from `n` numbers.

<p align="center">
  <img src="https://github.com/user-attachments/assets/415e5353-ecc6-40e6-8507-4baab6fe5bc3" alt="图片3" width="600">
</p>

```Java
public class Combinations {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return result;
    }
    public void backtracking(int n, int k, int startIndex){
        if(path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n ; i++) {
            path.push(i);
            backtracking(n, k, i+1); // Prevent repeated numbers.
            path.pop();
        }
    }
}
```

However, we can do some **trim operations** for backtracking problems. Since the backtracking method is essentially a brute-force search, we can optimize the algorithm through appropriate 
pruning. For example, in this problem, the range of the for loop can be optimized and pruned. Here, we use n=4 and k=4 as an example.


![image](https://github.com/user-attachments/assets/f0968455-a01f-41a7-b697-b51a9fa8b02f)

* Number of elements already selected: `path.size()`
* Number of elements still needed: `k-path.size()`
* In the set of n, at most, we need to start traversing from the position: `n-(k-path.size())+1`

```Java
public class Combinations02 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return result;
    }

    public void backtracking(int n, int k, int startIndex) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.push(i);
            backtracking(n, k, i + 1); // Prevent repeated numbers.
            path.pop();
        }
    }
}
```

## [216. Combination Sum III](https://leetcode.com/problems/combination-sum-iii/description/)

Find all valid combinations of `k` numbers that sum up to `n` such that the following conditions are true:

* Only numbers `1` through `9` are used.
* Each number is used **at most once**.

Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

**Example 1:**

**Input:** k = 3, n = 7 <br>
**Output:** [[1,2,4]] <br>
**Explanation:**<br>
1 + 2 + 4 = 7
There are no other valid combinations.

```Java
public class CombinationSumIII {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(n, k, 0, 1);
        return result;
    }
    public void backtracking(int targetSum, int k, int sum, int startIndex){
        if(path.size() == k){
            if(targetSum == sum)
                result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= 9; i++) {
            sum += i;
            path.add(i);
            backtracking(targetSum, k, sum, i+1);
            path.removeLast();
            sum-=i;

        }
    }
}
```
**Trim operation**
* If the total sum of the selected elements already exceeds n, then continuing the traversal is meaningless, and we can prune it directly.

* Similar to the backtracking algorithm for combination problems with pruning, the range of the for loop can also be pruned. The condition can be adjusted to `9-(k-path.size)+1`

```Java
public class CombinationSumIII02 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(n, k, 0, 1);
        return result;
    }

    public void backtracking(int targetSum, int k, int sum, int startIndex) {
        if (path.size() == k) {
            if(sum > targetSum) return;
            if (targetSum == sum)
                result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= 9-(k-path.size()) + 1; i++) {
            sum += i;
            path.add(i);
            backtracking(targetSum, k, sum, i + 1);
            path.removeLast();
            sum -= i;
        }
    }
}
```

## [Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/)

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in **any order**.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

![image](https://github.com/user-attachments/assets/9ea73ca0-3096-4105-9e18-ebbb2b388e07)

**Example 1:**

**Input:** digits = "23" <br>
**Output:** ["ad","ae","af","bd","be","bf","cd","ce","cf"]

**Ideas:** We can use a two-dimensional array to map characters to numbers, and then, by understanding the backtracking process based on the tree structure, we can write the code.

```Java
public class PhoneNumCombinations {
    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return result;
        // Map characters to numbers
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backTracking(digits, numString, 0);
        return result;
    }

    StringBuilder temp = new StringBuilder();
    public void backTracking(String digits, String[] numString, int index) {
        if (index == digits.length()) {
            result.add(temp.toString());
            return;
        }
        String str = numString[digits.charAt(index) - '0'];
        for (int i = 0; i < str.length(); i++) {
            temp.append(str.charAt(i));
            backTracking(digits, numString, index+1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
```



























