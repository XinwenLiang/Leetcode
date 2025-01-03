# 代码随想录算法训练营第二十三天
## [39. Combination Sum](https://leetcode.com/problems/combination-sum/description/)

Given an array of **distinct** integers `candidates` and a target integer `target`, return a list of all **unique combinations** of `candidates` where the chosen numbers sum to `target`. You may return the combinations in **any order**.

The **same** number may be chosen from `candidates` an **unlimited number of times**. Two combinations are unique if the 
frequency
 of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to `target` is less than `150` combinations for the given input.

**Example 1:**

**Input:** candidates = [2,3,6,7], target = 7<br>
**Output:** [[2,2,3],[7]]<br>
**Explanation:**
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.<br>
7 is a candidate, and 7 = 7.<br>
These are the only two combinations.

**Ideas:**
1. **Determining the Type and Parameters of the Recursive Function**:
* Define two global variables:A 2D array result to store the collection of results and an array path to store individual results that meet the conditions.
* The function type is void, as it does not return any value.
* For parameters, we pass in the target and candidate arrays from the problem statement. The sum parameter is used to calculate the total of the individual result stored in path, and startIndex is used to control the
starting point of the loop to prevent duplicate results.

2. **Determine the Termination Conditions:**
* If `target == sum`, it means the target result has been found. Add the current path to the result.
* If `sum > target`, return nothing.

3. **Single-Layer Search Logic:**
* Use a single for loop starting from `startIndex` to search through the `candidates` collection. This ensures that each recursive call explores only the relevant portion of the collection, avoiding duplicate results.

4. **Trim Operation**
* We should sort the candidates firstly, and then in the for loop, if `sum > target`, break the loop.

```Java
public class CombinationSum {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(result, path, candidates, target, 0, 0);
        return result;
    }

    public void backtracking(List<List<Integer>> res, List<Integer> path, int[] candidates, int target, int sum, int startIndex) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (sum > target) break;
            path.add(candidates[i]);
            sum += candidates[i];
            backtracking(res, path, candidates, target, sum, i);
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }
}
```

## [40. Combinations Sum II](https://leetcode.com/problems/combination-sum-ii/description/)

Given a collection of candidate numbers (`candidates`) and a target number (`target`), find all unique combinations in `candidates` where the candidate numbers sum to `target`.

Each number in `candidates` may only be used **once** in the combination.

**Note:** The solution set must not contain duplicate combinations.

**Example 1:**

**Input:** candidates = [10,1,2,7,6,1,5], target = 8 <br>
**Output:** 
[<br>
[1,1,6],<br>
[1,2,5],<br>
[1,7],<br>
[2,6]<br>
]

**Ideas:**
1. **Determining the Type and Parameters of the Recursive Function**:
* Define two global variables:A 2D array result to store the collection of results and an array path to store individual results that meet the conditions.
* The function type is void, as it does not return any value.
* For parameters, we pass in the target and candidate arrays from the problem statement. The sum parameter is used to calculate the total of the individual result stored in path, and startIndex is used to control the
starting point of the loop to prevent duplicate results. (Boolean type variable used to remove duplications, we can also use startIndex directly).

2. **Determine the Termination Conditions:**
* If `target == sum`, it means the target result has been found. Add the current path to the result.
* If `sum > target`, return nothing.

3. **Single-Layer Search Logic:** <br>
The goal is to eliminate duplicates "used on the same level of the tree". How can we determine if an element (of the same value) has already been used on the same level of the tree?

If `candidates[i] == candidates[i - 1]` and `used[i - 1] == false`, it indicates that the previous branch has used `candidates[i - 1]`, meaning `candidates[i - 1]` has been used on the same level of the tree.

At this point, the `for loop` should execute a continue operation. When `candidates[i] == candidates[i - 1]`, the scenarios are as follows:

* If `used[i - 1] == true`, it means `candidates[i - 1]` has been used on the same branch.
* If `used[i - 1] == false`, it means `candidates[i - 1]` has been used on the same level of the tree.

```Java
public class CombinationSumII {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        used = new boolean[candidates.length];
        Arrays.sort(candidates); // Sort the arrays for the convenience of trimming.
        backtracking(candidates, target, 0, 0);
        return res;
    }

    public void backtracking(int[] candidates, int target, int sum, int startIndex) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (sum + candidates[i] > target) break;
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }
            // Mark the current element as used and add to path.
            used[i] = true;
            path.add(candidates[i]);
            sum += candidates[i];
            backtracking(candidates, target, sum, i + 1);

            // backtrack: undo changes
            path.removeLast();
            used[i] = false;
            sum -= candidates[i];
        }
    }
}
```

## [131. Palindrome Partitioning](https://leetcode.com/problems/palindrome-partitioning/description/)

Given a string `s`, partition `s` such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of `s`.

**Example 1:**

**Input:** s = "aab" <br>
**Output:** [["a","a","b"],["aa","b"]]

**Ideas:** 
1. **Determining the Type and Parameters of the Recursive Function**:
* Define two global variables:A 2D array result to store the collection of results and an array path to store individual results that meet the conditions.
* The function type is void, as it does not return any value.
* For parameters, we pass in the target and candidate arrays from the problem statement. The `startIndex` is used to control the starting point of the loop to prevent duplicate results. Actually, `startIndex` represents the dividing line.
2. **Determine the Termination Conditions:**
* If `startIndex >= s.size()`, then we find a partition case.
3. **Single-Layer Search Logic:** <br>
* In the loop `for (int i = startIndex; i < s.size(); i++)`, we define the starting position `startIndex`. Thus, `[startIndex, i]` represents the substring to be extracted.
First, we check whether this substring is a palindrome. If it is, we add it to the `path`, which is used to record the palindromic substrings obtained from the partition.
3. **Determine a palindrome partitioning:**
* We can use Two-Pointer method to check if the substring is a palindrome.

```Java
public class Palindrome {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtracking(s,0,new StringBuilder());
        return res;
    }
    public void backtracking(String s, int startIndex, StringBuilder sb){
        if (startIndex == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <s.length() ; i++) {
            sb.append(s.charAt(i));
            if(isPalindrome(sb)){
                path.add(sb.toString());
                backtracking(s,i+1,new StringBuilder());
                path.remove(path.size() - 1);
            }
        }
    }
    public boolean isPalindrome(StringBuilder sb){
        for (int i = 0; i < sb.length()/2; i++) {
            if(sb.charAt(i) != sb.charAt(sb.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}
```




















