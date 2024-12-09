# 代码随想录算法训练营第二十七天
## [455. Assign Cookies](https://leetcode.com/problems/assign-cookies/description/)

Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie.

Each child `i` has a greed factor `g[i]`, which is the minimum size of a cookie that the child will be content with; and each cookie `j` has a size `s[j]`. If `s[j] >= g[i]`, we can assign the cookie `j` to the child 
`i`, and the child `i` will be content. Your goal is to maximize the number of your content children and output the maximum number.

 

**Example 1:**

**Input:** g = [1,2,3], s = [1,1] <br>
**Output:** 1<br>
**Explanation:** You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3. <br>
And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.<br>
You need to output 1.

**Ideas:**
Firstly, we can sort the two arrays by an increasing order. Then we can use two pointers `i` and `j` to point to the end of two arrays separately. The task needs to fix the array of children's appetites and dynamically adjust the array of cookies to ensure that larger cookies are given to children with bigger appetites.

```Java
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int i = g.length - 1;
        int j = s.length - 1;
        while (i >= 0 && j >= 0) {
            if (s[j] >= g[i]) {
                count++;
                j--;
            }
            i--;
        }
        return count;
    }
}
```

## [376. Wiggle Subsequence](https://leetcode.com/problems/wiggle-subsequence/description/)
A wiggle sequence is a sequence where the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence 
with one element and a sequence with two non-equal elements are trivially wiggle sequences.

For example, [1, 7, 4, 9, 2, 5] is a wiggle sequence because the differences (6, -3, 5, -7, 3) alternate between positive and negative.
In contrast, [1, 4, 7, 2, 5] and [1, 7, 4, 5, 5] are not wiggle sequences. The first is not because its first two differences are positive, and the second is not because its last difference is zero.
A subsequence is obtained by deleting some elements (possibly zero) from the original sequence, leaving the remaining elements in their original order.

Given an integer array nums, return the length of the longest wiggle subsequence of nums.

 

Example 1:

Input: nums = [1,7,4,9,2,5]
Output: 6
Explanation: The entire sequence is a wiggle sequence with differences (6, -3, 5, -7, 3).
























