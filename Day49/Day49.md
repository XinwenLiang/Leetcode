# 代码随想录算法训练营第四十九天
## [42. Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/description/)

Given n non-negative integers representing an elevation map where the width of each bar is `1`, compute how much water it can trap after raining.

**Example 1:**
![image](https://github.com/user-attachments/assets/f0fa40bc-5775-4a03-a93d-1dc405c14dc3)

**Input:** height = [0,1,0,2,1,0,1,3,2,1,2,1] <br>
**Output:** 6 <br>
**Explanation:** The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

**Ideas:**
Approach1: **Brute Force Solution:** We can calculate either horizontally or vertically. Here, I choose the vertical approach because the width of each bar is fixed at `1`. We observe that the height of the water in 
each column depends on the shorter height between the tallest bar on the left and the tallest bar on the right of that column. Therefore, we can calculate the height of the water in each column, then multiply it by 
the width (1) to get the area of water in that column. Finally, we sum up the areas of water in all columns to obtain the result.

Approach2: **Tow-Pointer Solution:** We can traverse the array from right to left to calculate the maximum height of the bars to the right of each column, and from left to right to calculate the maximum height of the 
bars to the left of each column. Then, we compute the cumulative water area by summing up the results.

Approach3: **Monotonic Stack Solution:** We use a monotonically increasing stack to record the heights of the bars as we traverse the array. When encountering the same height, we update the index in the stack by 
popping the old index and pushing the new one. If the height of the current bar is less than the height of the top of the stack, we push this bar onto the stack because the stack must maintain an increasing order 
(from top to bottom).

If the height of the current bar is greater than the height of the top of the stack, this indicates the formation of a "valley." In this case, we pop the top of the stack, which represents the bottom of the valley. 
Let this index be mid, with a height of height[mid] (the valley bottom height).

The new top of the stack, st.peek(), represents the left boundary of the valley, with an index of st.peek() and a height of height[st.peek()] (the left boundary height).

The current bar being traversed, i, represents the right boundary of the valley, with an index of i and a height of height[i] (the right boundary height).

At this point, we can calculate the trapped water using these three elements: the top of the stack, the element just below it, and the current element.

* The height of the trapped water is: `h = min(height[st.top()], height[i]) - height[mid]` (minimum of the left and right boundaries minus the valley bottom height).

* The width of the trapped water is: `w = i - st.top() - 1` (distance between the left and right boundaries, excluding the valley).

* The volume of trapped water in the current valley is: `h * w`.

```Java
// Brute Force Solution
public class TrappingRainWater {
    public int trap(int[] height) {
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            if(i ==0 || i == height.length - 1) continue;
            int right = height[i];
            int left = height[i];
            for (int r = i+1; r < height.length ;r++) {
                if(height[r] > right) right = height[r];
            }
            for (int l = i-1; l >= 0; l--) {
                if(height[l] > left) left = height[l];
            }
            int h = Math.min(left, right) - height[i];
            if(h > 0)  result += h;
        }
        return result;
    }
}

// Two-pointer Solution
public class TrappingRainWaterII {
    public int trap(int[] height) {
        int result = 0;
        int len = height.length;
        int[] maxLeft = new int[len];
        int[] maxRight = new int[len];

        maxLeft[0] = height[0];
        for (int i = 1; i < len ; i++) {
            maxLeft[i] = Math.max(height[i],maxLeft[i-1]);
        }
        maxRight[len-1] = height[len-1];
        for (int i = len-2; i >=0 ; i--) {
            maxRight[i] = Math.max(height[i], maxRight[i+1]);
        }

        for (int i = 0; i < len; i++) {
            int h = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if(h > 0) result += h;
        }
        return result;
    }
}

// Monotonic Stack Solution
public class TrappingRainWaterIII {
    public int trap(int[] height) {
        if (height == null || height.length <= 2) return 0;
        Deque<Integer> st = new LinkedList<>();
        int result = 0;
        st.push(0);
        for (int i = 1; i < height.length; i++) {
            if (height[i] <= height[st.peek()]) {
                st.push(i);
            } else {
                while (!st.isEmpty() && height[i] > height[st.peek()]) {
                    int mid = st.peek();
                    st.pop();
                    if (!st.isEmpty()) {
                        int h = Math.min(height[st.peek()], height[i]) - height[mid];
                        int w = i - st.peek() - 1;
                        result += h * w;
                    }
                }
                st.push(i);
            }
        }
        return result;
    }
}
```


























