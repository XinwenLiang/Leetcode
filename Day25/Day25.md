# 代码随想录算法训练营第25天
## [491. Non-Decreasing Subsequence](https://leetcode.com/problems/non-decreasing-subsequences/description/)

Given an integer array `nums`, return all the different possible non-decreasing subsequences of the given array with at least two elements. You may return the answer in **any order**.

**Example 1:**

**Input:** nums = [4,6,7,7] <br>
**Output:** [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]

**Ideas:** <br>
The question is about finding an increasing subsequence, and the original array cannot be sorted. If the array is sorted, it would naturally become an increasing subsequence.

```Java
public class NonDecreasingSubsequence {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return res;
    }

    public void backtracking(int[] nums, int startIndex) {
        if (path.size() >= 2) {
            res.add(new ArrayList<>(path));
        }
        HashSet<Integer> hs = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            if (!path.isEmpty() && nums[i] < path.get(path.size() - 1) || hs.contains(nums[i])) {
                continue;
            }
            hs.add(nums[i]);
            path.add(nums[i]);
            backtracking(nums,i+1);
            path.remove(path.size()-1);
        }
    }
}
```

## [46. Permutations](https://leetcode.com/problems/permutations/description/)
Given an array `nums` of distinct integers, return all the possible permutations. You can return the answer in **any order**.

**Example 1:**

**Input:** nums = [1,2,3] <br>
**Output:** [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

**Ideas:**　<br>
Unlike combination problems, permutation problems do not require a startIndex to handle deduplication of previous elements. However, we need a boolean array `used` to mark elements that have already been used, as each 
element can only be used once.

```Java
public class Permutations {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) return res;
        used = new boolean[nums.length];
        backtracking(nums);
        return res;
    }

    public void backtracking(int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backtracking(nums);
            path.removeLast();
            used[i] = false;
        }
    }
}
```

## [47. Permutations II](https://leetcode.com/problems/permutations-ii/description/)

Given a collection of numbers, `nums`, that might contain duplicates, return all possible unique permutations in **any order**.

**Example 1:**

**Input:** nums = [1,1,2] <br>
**Output:**
[[1,1,2],<br>
 [1,2,1],<br>
 [2,1,1]]

 **Ideas:**

 Since this problem involves duplicate elements, it is necessary to deduplicate at the tree level. (Tree branch deduplication is also possible but less efficient.)

 ```Java
public class PermutationsII {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.fill(used, false);
        Arrays.sort(nums);
        backtracking(nums);
        return res;
    }

    public void backtracking(int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                continue;
            }
            if (used[i]) continue;
            used[i] = true;
            path.add(nums[i]);
            backtracking(nums);
            used[i] = false;
            path.removeLast();
        }
    }
}
```





























