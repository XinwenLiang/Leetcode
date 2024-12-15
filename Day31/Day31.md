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

## [968. Binary Tree Cameras](https://leetcode.com/problems/binary-tree-cameras/description/)

You are given the `root` of a binary tree. We install cameras on the tree nodes where each camera at a node can monitor its parent, itself, and its immediate children.

Return *the minimum number of cameras needed to monitor all nodes of the tree*.

**Example1:**

![image](https://github.com/user-attachments/assets/f884be6f-b587-460a-9314-8d74a82a360e)

**Input:** root = [0,0,null,0,0] <br>
**Output:** 1 <br>
**Explanation:** One camera is enough to monitor all nodes if placed as shown.

**Ideas:**

To maximize monitoring coverage, it is best to place cameras on the parent nodes of leaf nodes. The traversal order for the binary tree must be postorder, as this allows us to determine the state of a parent node 
based on the states of its left and right child nodes.

* Node States:
1. No Coverage: The node is not covered by any camera.(0)
2. Has Camera: The node has a camera installed.(1)
3. Covered: The node is covered by a camera (either from itself or its children).(2)
**Note:** Empty nodes should be assigned the Covered state by default.
* Four Scenarios:
1. Case 1: Both left and right children are covered. In this case, the parent node is in a No Coverage state. 
2. Case 2: At least one of the left or right children is in a No Coverage state. In this case, the parent node must have a camera installed.
3. Case 3: At least one of the left or right children is covered. In this case, the parent node is in a Covered state.
4. Case 4: After traversing the entire tree, if the root node is in a No Coverage state, an additional camera must be installed at the root.

```Java
public class BinaryTreeCameras {
    int result = 0;
    public int minCameraCover(TreeNode root) {
        // Case4: When the root has no cover, we need to set a camera.
        if(traversal(root) == 0){
            result ++;
        }
        return result;
    }
    public int traversal(TreeNode cur){
        if(cur == null) return 2;
        int left = traversal(cur.left);
        int right = traversal(cur.right);
        // Case1:Both the left and right child have the cover.
        if(left == 2 && right == 2) return 0;
        // Case2: The left and right child have at least one no-cover.
        if(left == 0 || right == 0){
            result++;
            return 1;
        }
        // Case3: The left and right child have at least one cover.
        if(left == 1 || right == 1) return 2;
        return -1;
    }
}
```






















