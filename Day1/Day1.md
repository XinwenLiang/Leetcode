# 代码随想录算法训练营第一天| 704.Binary Search
## 1. Binary Search
* Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1. You must write an algorithm with O(log n) runtime complexity.
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
