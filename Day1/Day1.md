# 代码随想录算法训练营第一天
## [704. Binary Search](https://leetcode.com/problems/binary-search/)

* Given an array of integers `nums` which is sorted in ascending order, and an integer `target`, write a function to search `target` in `nums`. If `target` exists, then return its index. Otherwise, return `-1`. You must write an algorithm with `O(log n)` runtime complexity.

* 思路：我们需要借助左右两个指针分别指向数组的首尾，通过判断中间值来决定移动左右指针中的哪一个指针。有两种不同写法：区间为左闭右闭以及区间为左闭右开：
1. 区间为左闭右闭的情况[left, right],当中间值大于target的时候，需要改变右端点，又因为右区间为闭区间，middle不可以取到，所以执行right = middle -1;
当中间值小于target时，需要改变左端点，同上缘由，执行left = middle + 1;

<p align="center">
  <img src="https://github.com/user-attachments/assets/18beb37f-a637-4ce9-b231-efcef0e55658" alt="图片1" width="600">
</p>

2. 区间为左闭右开的情况[left, right),当中间值大于target时，需要改变右端点，因为是开区间，可以直接执行right = middle(因为middle不会取到)
当中间值大于target时，需要改变左端点，但是不可以取到middle，所以left = middle + 1;

<p align="center">
  <img src="https://github.com/user-attachments/assets/7f01cd03-4144-4b68-9b42-18347d077cd7" alt="图片2" width="600">
</p>

## 2. Remove Element
* Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
Return k.
* 思路：首先想到的是可以使用暴力求解法，即通过两个循环，将不需去除的元素向左移覆盖需要删除的元素；除此之外可以通过双指针求解，我们用快指针来获取新数组的元素，用慢指针更新位置。具体代码如图所示。
* 图1：暴力求解法：

<p align="center">
  <img src="https://github.com/user-attachments/assets/2162d200-1f20-4026-95fe-faaa164ee38d" alt="图片3" width="600">
</p>

* 图2：快慢指针法：

<p align="center">
  <img src="https://github.com/user-attachments/assets/ff6402ea-81c9-408d-a1e0-874016312e9a" alt="图片4" width="600">
</p>

## 3. Squares of Sorted Array
* Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
* 思路：首先想到的是可以先生成平方数组，然后按照冒泡排序方法将其按照升序排列。其次我们可以使用双指针法，因为最大值肯定不会出现在数组中间，只有可能出现在负数最小值和正数最大值之间，
  所以我们将一个指针指向数组最左边，另一个指向数组最右边。如果left的值大于right值，则左指针右移；如果right值大于left值，则右指针左移。直到两指针相遇，循环结束。

  图1：暴力求解法：
  
<p align="center">
  <img src="https://github.com/user-attachments/assets/172e023d-ffe3-46ae-bf36-b7e131289849" alt="图片5" width="600">
</p>

图2：双指针法：

<p align="center">
  <img src="https://github.com/user-attachments/assets/4de77c89-7abe-4982-8002-c4f21d51093a" alt="图片6" width="600">
</p>

### The secret of getting ahead is getting started. -- Mark Twain























