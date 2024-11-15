# 代码随想录算法训练营第一天
## [704. Binary Search](https://leetcode.com/problems/binary-search/)

Given an array of integers `nums` which is sorted in ascending order, and an integer `target`, write a function to search `target` in `nums`. If `target` exists, then return its index. Otherwise, return `-1`. You must write an algorithm with `O(log n)` runtime complexity.

**Idea**：We need to use two pointers, one pointing to the start and the other to the end of the array. By comparing the middle value with the target, we decide which pointer to move. There are two different implementations: one where the interval is left-closed and right-closed, and another where it is left-closed and right-open.

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

**Idea**：The first approach that comes to mind is using the brute force method, which involves two loops to shift the elements that don't need to be removed to the left, overwriting the elements that need to be deleted. Alternatively, we can use the two-pointer technique: the fast pointer is used to retrieve the elements for the new array, while the slow pointer is used to update their positions.

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

## [977.Squares of Sorted Array](https://leetcode.com/problems/squares-of-a-sorted-array/)

Given an integer array `nums` sorted in **non-decreasing** order, return an array of the squares of each number sorted in **non-decreasing** order.

**Idea**：The first approach that comes to mind is to first generate an array of squares and then sort it in ascending order using the bubble sort method. Alternatively, we can use the two-pointer technique. Since the maximum value will not appear in the middle of the array, it can only be between the smallest negative number and the largest positive number. Thus, we place one pointer at the leftmost end of the array and the other at the rightmost end. If the value at left is greater than the value at `right`, move the `left` pointer to the `right`; if the value at `right` is greater than the value at `left`, move the `right` pointer to the `left`. The process continues until the two pointers meet, at which point the loop ends.

 ```Java
// Brute force method
public class SquaresOfSortedArray {
    public static int[] sortedSquares(int[] nums) {
        int[] arrNew = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arrNew[i] = nums[i] * nums[i];
        }
        // Sort the new array using the bubble sort method.
        int temp = 0;
        for (int i = 0; i < arrNew.length - 1; i++) {
            for (int j = 0; j < arrNew.length - 1; j++) {
                if (arrNew[j] > arrNew[j + 1]) {
                    temp = arrNew[j];
                    arrNew[j] = arrNew[j + 1];
                    arrNew[j + 1] = temp;
                }
            }
        }
        return arrNew;
    }
}

// Two pointers method
public class SquaresOfSortedArray02 {
   public static int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int index = nums.length - 1;
        int[] arrNew = new int[nums.length];
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                arrNew[index] = nums[left] * nums[left];
                index--;
                left++;
            } else {
                arrNew[index] = nums[right] * nums[right];
                index--;
                right--;
            }
        }
        return arrNew;
    }
}
```

### The secret of getting ahead is getting started. -- Mark Twain

<p align="center">
  <img src="https://github.com/user-attachments/assets/ad241a24-1ea7-47e5-afe9-18ed0310a885" alt="图片6" width="600">
</p>
























