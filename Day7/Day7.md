# 代码随想录算法训练营第七天
## [454. 4Sum](https://leetcode.com/problems/4sum-ii/description/)

Given four integer arrays `nums1`, `nums2`, `nums3`, and `nums4` all of length `n`, return the number of tuples `(i, j, k, l)` such that:

`0 <= i, j, k, l < n`<br>
`nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0`

**Example 1:**

**Input:** nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2] <br>
**Output:** 2

**Explanation:** <br>
The two tuples are:<br>
1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0 <br>
2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0 <br>
**Ideas:**


