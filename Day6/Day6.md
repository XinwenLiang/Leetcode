# 代码随想录算法训练营第6天
## [242. Valid Anagram](https://leetcode.com/problems/valid-anagram/description/)
Given two strings `s` and `t`, return `true` if `t` is an anagram of `s`, and `false` otherwise.

**Example1**<br>
**Input:** s = "anagram", t = "nagaram"

**Output:** true

**Ideas:**
* Use brute-force method: We can transform the strings to char arrays, sort them and then compare if they are equal.<br>
Time complexity: O(nlogn)

* Optimized method: Define a hash array of length 26 to store the frequency of each character. Then, traverse the string `s` to count the frequency of each letter and store it in the hash array. Next, traverse the string `t`, subtracting the frequency of each letter directly from the values in the hash array. If the final array contains all zeros, it indicates that the two strings are valid anagrams.

```Java
// Brute-force solution.
public class Anagram {
        public boolean isAnagram(String s, String t) {
            if(s.length() != t.length()){
                return false;
            }
            // Transform the Strings to char array.
            char[] sArray = s.toCharArray();
            char[] tArray = t.toCharArray();
            Arrays.sort(sArray);
            Arrays.sort(tArray);

           return Arrays.equals(sArray, tArray);
        }
}


//Hash method.
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;// Count the frequency of letters in String s.
        }

        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i) - 'a']--;
        }
        // If elements in count are all 0s, then s and t are anagrams.
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
```

## [349. Insection of Two Arrays](https://leetcode.com/problems/intersection-of-two-arrays/description/)
Given two integer arrays `nums1` and `nums2`, return an array of their intersection. Each element in the result must be **unique** and you may return the result in any order.

**Example1**

**Input:** nums1 = [1,2,2,1], nums2 = [2,2] <br>
**Output:** [2]

**Ideas**
1. When the array length is limited to below 1000, we can use an array to implement hashing.<br>
2. When the array length is not limited, we can use a `HashSet` to solve the problem.

<p align="center">
  <img src="https://github.com/user-attachments/assets/67c87b85-353a-44c6-9793-d4f251c58ab3" alt="图片3" width="600">
</p>

```Java
// Use hash arrays to complete.
public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] hash1 = new int[1002];
        int[] hash2 = new int[1002];
        // Count the frequency of every number in nums1.
        for(int i : nums1){
            hash1[i] ++;
        }
        // Count the frequency of every number in nums2.
        for(int i : nums2){
            hash2[i] ++;
        }

        // Define a list to store the intersection of nums1 and nums2.
        List<Integer> result = new ArrayList<>();

        // Check if there exists intersection.
        for (int i = 0; i < 1002; i++) {
            if(hash1[i] > 0 && hash2[i] >0){
                result.add(i);
            }
        }
        // Transform the list to the array.
        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }
}

// Use hashset to complete.
public class Intersection_Hashset {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null && nums1.length == 0 && nums2 == null && nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            if (set1.contains(i)) {
                result.add(i);
            }
        }
        //Transform the hash set to the array.
        int[] arr = new int[result.size()];
        int index = 0;
        for (int i : result) {
            arr[index++] = i;
        }
        return arr;
    }
}
```

































