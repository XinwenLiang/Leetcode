# 代码随想录算法训练营第七天
## [454. 4Sum](https://leetcode.com/problems/4sum-ii/description/)

Given four integer arrays `nums1`, `nums2`, `nums3`, and `nums4` all of length `n`, return the number of tuples `(i, j, k, l)` such that:

`0 <= i, j, k, l < n`<br>
`nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0`

**Example 1:**

**Input:** nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2] <br>
**Output:** 2

**Explanation:** <br>
The two tuples are:

1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0 
2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0

**Ideas:** <br>
1. First, define a map to store the frequency of sums of elements from arrays A and B. The key represents the sum of elements, and the value represents how many times this sum occurs.

2. Iterate through arrays A and B to calculate the sum of their elements (a + b), record the frequency of each sum, and store it in the map.

3. Then, iterate through arrays C and D, and for each sum (c + d), check if the map contains the value 0 - (c + d). If it exists, add the corresponding value in the map to the count variable. 

4. Finally, return the value of the count variable.

```Java
public class FourSum {
   public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4){
       int count = 0; // Define a count variable.
       // Define a map to store the sum of a and b.
       Map<Integer, Integer> sumOfTwo = new HashMap<>();
       for (int i : nums1) {
           for(int j : nums2){
               int sum = i+j;
               sumOfTwo.put(sum, sumOfTwo.getOrDefault(sum,0)+1);
           }
       }
       // Look up the target(0-c-d) in the map.
       for(int i : nums3){
           for(int j : nums4){
               int sum2  = i + j;
               int target = 0 - sum2;
               if (sumOfTwo.containsKey(target)){
                   count = count + sumOfTwo.getOrDefault(target, 0);
               }
           }
       }
       return count;
   }
}
```

## [383. Ransom Note](https://leetcode.com/problems/ransom-note/description/)

Given two strings `ransomNote` and `magazine`, return `true` if `ransomNote` can be constructed by using the letters from `magazine` and `false` otherwise.

Each letter in `magazine` can only be used once in `ransomNote`.

**Example 1:**

**Input:** ransomNote = "a", magazine = "b" <br>
**Output:** false

**Ideas:** From the problem description, we can sense that this question is quite similar to the valid anagram problem we solved before. Therefore, we can use a brute force method or utilize a hash array to solve it.

**Hash Array Method:** Since the problem states that there are **only lowercase letters**, we can create an array of length 26 to store the frequency of each letter in the `magazine`. Then, we iterate the `ransomNote` to check whether the corresponding letters exist in the array. If they do, return `true`; otherwise, return `false`.

```Java
// Brute-force method.
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() == 0) { // If the ransomNote is empty, return true.
            return true;
        }
        // Transform the string into char array so that we can modify the elements in it.
        char[] magazineChars = magazine.toCharArray();
        // Iterate elements in ransomNote to check if we can find it in the magazine.
        for (int i = 0; i < ransomNote.length(); i++) {
            char target = ransomNote.charAt(i);
            boolean found = false;
            for (int j = 0; j < magazineChars.length; j++) {
                if (magazineChars[j] == target) {
                    magazineChars[j] = '*'; // Mark the letter as used.
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }
}

// Hash-Array method.
 public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()){
            return false;
        }
        int[] arr1 = new int[26];
        // Iterate the magazine to store the number of every element in it.
        for (int i = 0; i < magazine.length(); i++) {
            arr1[magazine.charAt(i) - 'a'] ++;
        }
        // Iterate the ransomNote to look up if the element exists in the magazine.
        for(int j =0; j < ransomNote.length(); j++){
            arr1[ransomNote.charAt(j)-'a']--;
        }
        // If there exists negative number in arr1, that means there is element in ransomNote cannot find in magazine.
        for(int i : arr1){
            if(i < 0){
                return false;
            }
        }
        return true;
    }
}
```

## [15. 3Sum](https://leetcode.com/problems/3sum/description/)

Given an integer array nums, return all the triplets `[nums[i], nums[j], nums[k]]` such that `i != j, i != k`, and `j != k`, and `nums[i] + nums[j] + nums[k] == 0`.

Notice that the solution set must not contain duplicate triplets.

 

**Example 1:**

**Input:** nums = [-1,0,1,2,-1,-4]<br>
**Output:** [[-1,-1,2],[-1,0,1]]

**Explanation:**

nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.<br>
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.<br>
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.<br>
The distinct triplets are [-1,0,1] and [-1,-1,2].<br>
Notice that the order of the output and the order of the triplets does not matter.<br>

**Ideas:**

Since this problem involves removing duplicates, it can be challenging to solve using hashing. So, we shift our approach to the two-pointer method.<br>
First, we sort the array in ascending order. Then, we iterate through the array, fixing one element a at a time. We set two pointers: `left` pointing to `i + 1` and `right` pointing to the end of the array. If the sum of the three numbers is greater than 0, we move the `right` pointer to the `left`; if the sum is less than 0, we move the `left` pointer to the `right`.

The most crucial part is **handling duplicate elements**. Before moving the pointers, we ensure that duplicates of a are skipped by checking the condition `nums[i] == nums[i - 1]`. After obtaining a valid result, we also skip duplicates of b and c to avoid missing a valid result.

```Java
public class ThreeSums {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        // Look up a+b+c=0, a = nums[i], b = nums[left], c = nums[right]
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0){
                return result;
            }
            if(i > 0 && nums[i]==nums[i-1]){// Remove the duplicate result for a.
                continue;
            }
            int left = i +1;
            int right = nums.length -1;
            while(right > left){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum> 0){ // If a+b+c>0, that means we need to reduce the sum.
                    right--;
                }else if(sum< 0){// If a+b+c<0, that means we need to increase the sum.
                    left ++;
                }else{
                    result.add(Arrays.asList(nums[i], nums[left],nums[right]));
                    // Remove the duplicate b and c.
                    while(right > left && nums[right] == nums[right-1]) right --;
                    while(right > left && nums[left] == nums[left+1]) left++;

                    right--;
                    left++;
                }
            }
        }
        return result;
    }
}
```

## [18. 4Sum](https://leetcode.com/problems/4sum/description/)

Given an array `nums` of `n` integers, return an array of all the **unique** quadruplets `[nums[a], nums[b], nums[c], nums[d]]` such that:

* `0 <= a, b, c, d < n`
* `a`, `b`, `c`, and `d` are distinct.
* `nums[a] + nums[b] + nums[c] + nums[d] == target`

You may return the answer in **any order**.

**Example 1:** <br>

**Input:** nums = [1,0,-1,0,-2,2], target = 0 <br>
**Output:** [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

**Ideas:**

In fact, most of the logic overlaps with the three-sum problem. The main difference is that an additional loop for the new number `k` is added outside, with pruning and deduplication operations applied to both `k` and `i`.

* First-level pruning condition: `nums[k] > target && nums[k] > 0 && target > 0` (If the current number exceeds the target or is positive, stop further exploration).<br>
* First-level deduplication condition: `k > 0 && nums[k] == nums[k-1]`  (Skip duplicate values for `k` when the `target` is positive).<br>
* Second-level pruning condition: `ums[k] + nums[i] > target && nums[k] + nums[i] > 0 && target > 0` (If the sum of `nums[k]` and `nums[i]` exceeds the `target` or is positive, stop further exploration for this combination).<br>
* Second-level deduplication condition: `i == k + 1 && nums[i] == nums[i-1]` (Skip duplicate values for `i`, ensuring that only unique pairs are considered after fixing `k`).

```Java
public class FourSums {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] > target && nums[k] > 0 && target > 0) {
                break; //First level pruning operation.
            }
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue; // First level deduplication operation.
            }
            for (int i = k + 1; i < nums.length; i++) {
                int sum1 = nums[i] + nums[k];
                if (sum1 > target && sum1 > 0 && target > 0) {
                    break; // Second level pruning operation.
                }
                if (i > k + 1 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int sum = 0;
                int left = i + 1;
                int right = nums.length - 1;
                while (right > left) {
                    sum = nums[k] + nums[i] + nums[right] + nums[left];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        result.add(Arrays.asList(nums[k], nums[i], nums[left], nums[right]));
                        while (right > left && nums[right] == nums[right - 1]) right--;
                        while (right > left && nums[left] == nums[left + 1]) left++;

                        right--;
                        left++;
                    }
                }
            }
        }
        return result;
    }
}
```

## [Every single day counts.](https://c6.y.qq.com/base/fcgi-bin/u?__=19GTxFF7P0Aa) 

<p align="center">
  <img src="https://github.com/user-attachments/assets/2510cb9f-9fdd-4a1f-a92a-62be2caf2a6f" alt="图片3" width="600">
</p>































