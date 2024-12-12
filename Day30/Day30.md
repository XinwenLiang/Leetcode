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
























