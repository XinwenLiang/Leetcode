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










