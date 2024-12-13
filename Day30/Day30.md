# 代码随想录算法训练营第三十天
## [452. Minimum Number of Arrows to Burst Ballons](https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/)

There are some spherical balloons taped onto a flat wall that represents the XY-plane. The balloons are represented as a 2D integer array `points` where `points[i] = [xstart, xend]` denotes a balloon whose horizontal 
diameter stretches between `xstart` and `xend`. You do not know the exact y-coordinates of the balloons.

Arrows can be shot up **directly vertically** (in the positive y-direction) from different points along the x-axis. A balloon with `xstart` and `xend` is **burst** by an arrow shot at x if `xstart <= x <= xend`. There 
is **no limit** to the number of arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any balloons in its path.

Given the array `points`, return *the **minimum** number of arrows that must be shot to burst all balloons*.

**Example 1:**

**Input:** points = [[10,16],[2,8],[1,6],[7,12]] <br>
**Output:** 2 <br>
**Explanation:** The balloons can be burst by 2 arrows: <br>
- Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].<br>
- Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].<br>

**Ideas:** The local optimum is to keep the overlapping balloons as close together as possible, with the fewest arrows to shoot through.

```Java
public class MinimumArrows {
    public int findMinArrowShots(int[][] points){
        if(points == null) return 0;
        Arrays.sort(points, (a,b) -> Integer.compare(a[0],b[0]));
        int result =1;
        for (int i = 1; i < points.length; i++) {
            if(points[i][0] > points[i-1][1]){
                result++;
            }else{
                points[i][1] = Math.min(points[i-1][1], points[i][1]);
            }
        }
        return result;
    }
```

## [435. Non-Overlapping-Intervals](https://leetcode.com/problems/non-overlapping-intervals/description/)

Given an array of intervals `intervals` where `intervals[i] = [starti, endi]`, return *the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping*.

**Note** that intervals which only touch at a point are **non-overlapping**. For example, `[1, 2]` and `[2, 3]` are non-overlapping.

**Example 1:**

**Input:** intervals = [[1,2],[2,3],[3,4],[1,3]] <br>
**Output:** 1 <br>
**Explanation:** [1,3] can be removed and the rest of the intervals are non-overlapping.

**Ideas:** We first sort the intervals by their left boundaries. The logic for checking overlap is `nums[i][0] < nums[i-1][1]`. To determine if the next interval overlaps, we need to update the value of `nums[i][1]` 
by taking the minimum of the right boundaries of the two intervals: `nums[i][1] = Math.min(nums[i-1][1], nums[i][1])`.

```Java
public class EraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) ->{
            return Integer.compare(a[0],b[0]);
        });
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < intervals[i-1][1]){
                count++;
                intervals[i][1] = Math.min(intervals[i-1][1], intervals[i][1]);
            }
        }
        return count;
    }
}
```

## [763. Partition Labels](https://leetcode.com/problems/partition-labels/description/)

You are given a string `s`. We want to partition the string into as many parts as possible so that each letter appears in at most one part.

Note that the partition is done so that after concatenating all the parts in order, the resultant string should be `s`.

Return *a list of integers representing the size of these parts*.

**Example 1:**

**Input:** s = "ababcbacadefegdehijhklij" <br>
**Output:** [9,7,8] <br>
**Explanation:** 
The partition is "ababcbaca", "defegde", "hijhklij". <br>
This is a partition so that each letter appears in at most one part.<br>
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.

**Ideas:** We first need to record the furthest position where each letter appears. Then, we iterate through each letter one by one and update the furthest occurrence index of the character. If 
the furthest occurrence index of a character matches the current index, we have found a partition point.

```Java
public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[] edge = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            edge[chars[i] - 'a'] = i;
        }
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            right = Math.max(right, edge[chars[i] -'a']);
            if(i == right){
                res.add(right - left +1);
                left  = i+1;
            }
        }
        return res;
    }
}
```

















