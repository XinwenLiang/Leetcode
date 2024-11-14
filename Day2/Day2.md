# 代码随想录算法训练营第二天
## Minimum Size Subarray Sum
* Given an array of positive integers nums and a positive integer target, return the minimal length of a
  subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
* 思路：可以使用暴力解法，使用两个for循环分别代表区间起点和区间终点。优化算法是利用滑动窗口思想，其实与昨天双指针相比，本题不过是取到双指针中间部分。
  我们可以不断调整起点和终点位置，直到我们找到满足条件的最小长度的数组。用一个for循环来表示滑动窗口，如果我们选择起点作为循环变量会发现依旧会陷入暴力
解法的循环中，所以我们应该选取终点作为循环变量，具体代码如图所示。

<p align="center">
  <img src="https://github.com/user-attachments/assets/f36937a0-fff0-4b46-bf7a-9a90e94b4b55" alt="图片1" width="600">
</p>

<p align="center">
  <img src="https://github.com/user-attachments/assets/c53aae8b-f4b0-42be-8779-1e5b70414d7b" alt="图片2" width="600">
</p>

## Spiral Matrix
* Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
* 思路可以参考下图，因为直接思考n个元素有些复杂，我们以n=3为例，去看如何循环。通过观察规律不难发现，矩阵的圈数是int(n/2)即需要向下取整，然后分别循环四条边即可。
  （画图会让整个思路很清晰，强烈建议大家画个图，一目了然）

  <p align="center">
  <img src="https://github.com/user-attachments/assets/746ea714-ce51-43c6-851d-d7279f371da2" alt="图片3" width="600">
</p>

* 代码如下
  
<p align="center">
  <img src="https://github.com/user-attachments/assets/bbf6381f-67da-41a2-b22a-80f9c1e88435" alt="图片3" width="600">
</p>

## In all the shabby fading, please shine forever.
