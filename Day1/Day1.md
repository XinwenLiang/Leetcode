# 代码随想录算法训练营第一天
## [704. Binary Search](https://leetcode.com/problems/binary-search/)

Given an array of integers `nums` which is sorted in ascending order, and an integer `target`, write a function to search `target` in `nums`. If `target` exists, then return its index. Otherwise, return `-1`. You must write an algorithm with `O(log n)` runtime complexity.

** Idea **：We need to use two pointers, one pointing to the start and the other to the end of the array. By comparing the middle value with the target, we decide which pointer to move. There are two different implementations: one where the interval is left-closed and right-closed, and another where it is left-closed and right-open.

1. For the left-closed, right-closed interval `[left, right]`:<br>
* When the middle value is greater than the `target`, we need to adjust the right endpoint. Since the right interval is closed, middle cannot be included, so we execute `right = middle - 1`.
* When the middle value is less than the `target`, we need to adjust the left endpoint. For the same reason, we execute `left = middle + 1`.

```Java
public class BinarySearch {
    // Case1: Left-closed and right-closed interval.
    public static int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        if (target >= arr[0] && target <= arr[arr.length - 1]) {
            while (left <= right) {
                int middle = (left + right) / 2;
                if (arr[middle] > target) {
                    right = middle - 1;
                } else if (arr[middle] < target) {
                    left = middle + 1;
                } else {
                    return middle;
                }
            }
        }
        return -1;
    }
```

2. For the left-closed, right-open interval [left, right):<br>

* When the middle value is greater than the `target`, we need to adjust the right endpoint. Since it is an open interval, we can directly execute `right = middle` (because middle is not included in the interval).

* When the middle value is less than the `target`, we need to adjust the left endpoint. However, middle cannot be included, so we execute `left = middle + 1`.

```Java
public class BinarySearch {
// Case2: Left-closed and right-opened interval.
  public static int BinarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        if (target >= arr[left] && target <= arr[arr.length- 1]) {
            while (left < right) {
                int middle = (right + left) / 2;
                if (arr[middle] < target) {
                    left = middle + 1;
                } else if (arr[middle] > target) {
                    right = middle;
                } else {
                    return middle;
                }
            }
        }
        return -1;
    }
```

## [27.Remove Element](https://leetcode.com/problems/remove-element/)

Given an integer array `nums` and an integer `val`, remove all occurrences of `val` in `nums` in-place. The order of the elements may be changed. Then return the number of elements in `nums` which are not equal to `val`.<br>
Consider the number of elements in `nums` which are not equal to `val` be `k`, to get accepted, you need to do the following things:
* Change the array `nums` such that the first `k` elements of `nums` contain the elements which are not equal to `val`. The remaining elements of `nums` are not important as well as the size of `nums`.
* Return `k`.

** Idea **：The first approach that comes to mind is using the brute force method, which involves two loops to shift the elements that don't need to be removed to the left, overwriting the elements that need to be deleted. Alternatively, we can use the two-pointer technique: the fast pointer is used to retrieve the elements for the new array, while the slow pointer is used to update their positions.

```Java
// Brute force method
public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == val) {
                for (int j = i; j < n - 1; j++) {
                    nums[j] = nums[j+1];
                }
                i--;
                n--;
            }
        }
        return n;
    }
}

// Two pointers method
public class RemoveElement02 {
 public static int removeElement(int[] nums, int val) {
    int slow = 0;
    for (int fast = 0; fast < nums.length; fast++){
        if(nums[fast] != val){
            nums[slow] = nums[fast];
            slow++;
        }
    }
    return slow;
    }
}
```

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

<p align="center">
  <img src="https://github.com/user-attachments/assets/ad241a24-1ea7-47e5-afe9-18ed0310a885" alt="图片6" width="600">
</p>
























