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






























