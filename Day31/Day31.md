# 代码随想录算法训练营第三十一天
## [Merge Intervals](https://leetcode.com/problems/merge-intervals/description/)

Given an array of `intervals` where `intervals[i] = [starti, endi]`, merge all overlapping intervals, and return *an array of the non-overlapping intervals that cover all the intervals in the input*.

**Example 1:**

**Input:** intervals = [[1,3],[2,6],[8,10],[15,18]] <br>
**Output:** [[1,6],[8,10],[15,18]] <br>
**Explanation:** Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

**Ideas:**  First, sort the intervals based on their left boundaries. Then, determine whether two intervals overlap by checking if the left boundary of the current interval is less than the right boundary of the previous 
interval. The merging logic is to keep the left boundary unchanged while updating the right boundary to the maximum value between the current interval's right boundary and the right boundary of the last interval in the 
result set.

```Java
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new LinkedList<>();
        if (intervals.length == 0) return intervals;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        res.add(intervals[0]);
        for (int i = 0; i < intervals.length; i++) {
            int[] lastInterval = res.get(res.size() - 1);
            if (intervals[i][0] <= lastInterval[1]) {
                lastInterval[1] = Math.max(intervals[i][1], lastInterval[1]);
            } else {
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
```

## [738. Monotone Increasing Digits](https://leetcode.com/problems/monotone-increasing-digits/description/)

An integer has **monotone increasing digits** if and only if each pair of adjacent digits `x` and `y` satisfy `x <= y`.

Given an integer `n`, return *the largest number that is less than or equal to n with monotone increasing digits*.

**Example 1:**

**Input:** n = 10 <br>
**Output:** 9

**Example 2:**

**Input:** n = 1234<br>
**Output:** 1234 

**Example 3:**

**Input:** n = 332<br>
**Output:** 299

**Ideas:** For this problem, we can only iterate from back to front. Then, define a `flag` variable to record the position from which all subsequent digits should be changed to 9.

```Java
public class IncreasingNumber {
    public int monotoneIncreasingDigits(int n) {
        String str = String.valueOf(n);
        char[] chars = str.toCharArray();
        int flag = str.length();
        for (int i = str.length() - 1; i > 0; i--) {
            if (chars[i - 1] > chars[i]) {
                chars[i - 1]--;
                flag = i;
            }
        }
        for (int i = flag; i < str.length(); i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(String.valueOf(chars));
    }
}
```




























