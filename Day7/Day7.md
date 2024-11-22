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

**Input:** ransomNote = "a", magazine = "b"
**Output:** false

**Ideas:**





























