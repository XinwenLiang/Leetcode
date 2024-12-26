# 代码随想录算法训练营第四十三天
## [300. Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/description/)

Given an integer array `nums`, return the length of the longest **strictly increasing** subsequence.

**Example 1:**

**Input:** nums = [10,9,2,5,3,7,101,18] <br>
**Output:** 4 <br>
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

**Ideas:**
1. Define the dp Array and Its Index Meaning
   dp[i] represents the length of the longest incremental subsequence ending in nums[i].
2. Determine the Recurrence Relation (State Transition Equation)
   dp[i] = Math.max(dp[j]+1, dp[i])
3. Initialize the dp array.
   dp[i] = 1 Because the length of increasing subsequence must be more than 1.
4. Determine the Traversal Order
   traverse from front to back and return the largest number in dp array.

```Java
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums){
        if (nums.length == 1) return 1;
        int[] dp = new int[nums.length];
        // Initialize the dp array.
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < nums.length ; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        int result = 0;
        for(int num : dp){
            result = Math.max(result, num);
        }
        return result;
    }
}
```

## [674. Longest Continuous Increasing Subsequence](https://leetcode.com/problems/longest-continuous-increasing-subsequence/description/)

Given an unsorted array of integers `nums`, return *the length of the longest continuous increasing subsequence (i.e. subarray)*. The subsequence must be **strictly** increasing.

A **continuous increasing subsequence** is defined by two indices `l`and `r` (`l < r`) such that it is `[nums[l]`, `nums[l + 1]`, ..., `nums[r - 1]`, `nums[r]]` and for each `l <= i < r`, `nums[i] < nums[i + 1]`.

**Example 1:**

**Input:** nums = [1,3,5,4,7] <br>
**Output:** 3 <br>
**Explanation:** The longest continuous increasing subsequence is [1,3,5] with length 3. <br>
Even though [1,3,5,7] is an increasing subsequence, it is not continuous as elements 5 and 7 are separated by element 4.

**Ideas:**
1. Define the dp Array and Its Index Meaning
   dp[i] represents the length of the longest continuous incremental subsequence ending in nums[i].
2. Determine the Recurrence Relation (State Transition Equation)
   if(nums[i] > nums[i-1]) dp[i] = dp[i-1] +1;
3. Initialize the dp array.
   dp[i] = 1 Because the length of increasing subsequence must be more than 1.
4. Determine the Traversal Order
   traverse from front to back and return the largest number in dp array.

```Java
public class LengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 1) return 1;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < nums.length ; i++) {
           if(nums[i] > nums[i-1]){
               dp[i] = dp[i-1] + 1;
            }
        }
        int result = 0;
        for(int num : dp){
            result = Math.max(result, num);
        }
        return result;
    }
}
```

## [718. Maximum Length of Repeated Subarray](https://leetcode.com/problems/maximum-length-of-repeated-subarray/description/)

Given two integer arrays `nums1` and `nums2`, return the maximum length of a subarray that appears in both arrays.

**Example 1:**

**Input:** nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
**Output:** 3
**Explanation:** The repeated subarray with maximum length is [3,2,1].

**Ideas:**
1. Define the dp Array and Its Index Meaning
   dp[i][j] represents the length of the longest repeated subarray ending in nums1[i-1] and nums2[j-1].
2. Determine the Recurrence Relation (State Transition Equation)
   if(nums1[i-1] == nums2[j-1]) dp[i][j] = dp[i-1][j-1] + 1;
3. Initialize the dp array.
   dp[i][0] = dp[0][j] = 0;
4. Determine the Traversal Order
   traverse from front to back and return the largest number in dp array.

```Java
public class LongestRepeatedSubarray {
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length +1][nums2.length + 1];
        int res = 0;
        for (int i = 1; i < nums1.length + 1; i++) {
            for (int j = 1; j < nums2.length + 1; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }
}
```




























