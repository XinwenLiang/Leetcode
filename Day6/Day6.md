# 代码随想录算法训练营第6天
## [242. Valid Anagram](https://leetcode.com/problems/valid-anagram/description/)
Given two strings `s` and `t`, return `true` if `t` is an anagram of `s`, and `false` otherwise.

**Example1**<br>
**Input:** s = "anagram", t = "nagaram"

**Output:** true

**Ideas:**
* Use brute-force method: We can transform the strings to char arrays, sort them and then compare if they are equal. Time complexity: (O(nlogn))

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
