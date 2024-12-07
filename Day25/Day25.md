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

**Idea**　<br>
Unlike combination problems, permutation problems do not require a startIndex to handle deduplication of previous elements. However, we need a boolean array `used` to mark elements that have already been used, as each 
element can only be used once.

```Java






























