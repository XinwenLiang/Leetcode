# 代码随想录算法训练营第二天
## Minimum Size Subarray Sum
* Given an array of positive integers nums and a positive integer target, return the minimal length of a
  subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
* 思路：可以使用暴力解法，使用两个for循环分别代表区间起点和区间终点。优化算法是利用滑动窗口思想，其实与昨天双指针相比，本题不过是取到双指针中间部分。
  我们可以不断调整起点和终点位置，直到我们找到满足条件的最小长度的数组。用一个for循环来表示滑动窗口，如果我们选择起点作为循环变量会发现依旧会陷入暴力
  解法的循环中，所以我们应该选取终点作为循环变量，具体代码如图所示。
  