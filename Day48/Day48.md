# 代码随想录算法训练营第四十八天
## [739. Daily Temperatures](https://leetcode.com/problems/daily-temperatures/description/)

Given an array of integers `temperatures` represents the daily temperatures, return an array `answer` such that `answer[i]` is the number of days you have to wait after the `ith` day to get a warmer temperature. If there 
is no future day for which this is possible, keep `answer[i] == 0` instead.

**Example 1:**

**Input:** temperatures = [73,74,75,71,69,72,76,73] <br>
**Output:** [1,1,4,2,1,1,0,0]

**Ideas:**
We can immediately think of using a data structure to store the elements for this problem. Since the task is to find the distance to the first greater element after the current one, we can consider using a monotonic 
stack. The stack will maintain a strictly increasing order from the top to the bottom, and it will store the indices of the elements.

For each current element, we compare it with the element at the top of the stack. If the current element is smaller than or equal to the top element, we push its index onto the stack and continue. If the current 
element is greater, we collect the result, pop the top element from the stack, and then push the current element's index onto the stack.

```Java
public class DailyTemperature {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        Deque<Integer> st = new LinkedList<>();
        st.push(0); // Default to put the first element.
        for (int i = 1; i < temperatures.length; i++) {
                while (! st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                    result[st.peek()] = i - st.peek();
                    st.pop();
                }
                st.push(i);
            }
        return result;
    }
}
```

## [496. Next Greater ElementI](https://leetcode.com/problems/next-greater-element-i/)

The **next greater element** of some element `x` in an array is the **first greater** element that is **to the right** of `x` in the same array.

You are given two **distinct 0-indexed** integer arrays `nums1` and `nums2`, where `nums1` is a subset of `nums2`.

For each `0 <= i < nums1.length`, find the index `j` such that `nums1[i] == nums2[j]` and determine the next greater element of `nums2[j]` in `nums2`. If there is no next greater element, then the answer for this 
query is `-1`.

Return *an array `ans` of length `nums1.length` such that `ans[i]` is the next greater element as described above*.

**Example 1:**

**Input:** nums1 = [4,1,2], nums2 = [1,3,4,2] <br>
**Output:** [-1,3,-1] <br>
**Explanation:** The next greater element for each value of nums1 is as follows: <br>
- 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1. <br>
- 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3. <br>
- 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1. <br>

**Ideas:**
For this problem, we need to define a `result` array with the same size as `nums1`, initialized with default values of `-1`. Then, we use a map to store the elements of `nums1`, and a monotonic stack to perform the 
element mapping operations.

```Java
public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Arrays.fill(result, -1);
        Deque<Integer> st = new LinkedList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        if(nums1.length == 0) return result;
        // Put elements of nums1 into the hashMap.
        for (int i = 0; i < nums1.length; i++) {
            hashMap.put(nums1[i],i);
        }
        st.push(0);
        for (int i = 1; i < nums2.length ; i++) {
            if(nums2[i] <= nums2[st.peek()]){
                    st.push(i);
            }else{
                while(!st.isEmpty() && nums2[i] > nums2[st.peek()]){
                    int index = st.pop();
                    if(hashMap.containsKey(nums2[index])){
                        int resultIndex = hashMap.get(nums2[index]);
                        result[resultIndex] = nums2[i];
                    }
                }
                st.push(i);
            }
        }
        return result;
    }
}
```

## [503. Next Greater ElementII](https://leetcode.com/problems/next-greater-element-ii/description/)

Given a circular integer array `nums` (i.e., the next element of `nums[nums.length - 1]` is `nums[0]`), return *the next greater number for every element in nums*.

The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return `-1` 
for this number.

**Example 1:**

**Input:** nums = [1,2,1] <br>
**Output:** [2,-1,2] <br>
**Explanation:** The first 1's next greater number is 2; <br> 
The number 2 can't find next greater number. <br>
The second 1's next greater number needs to search circularly, which is also 2.

**Ideas:**
This problem differs from the previous one in that it requires simulating a circular array. Naturally, we might think of extending the length of the original array to simulate the circle, but this approach results in 
a time complexity of O（n*n)

Another approach is to iterate through the array twice while using the **modulo operation** to simulate the circular behavior. This cleverly mimics the circular array without actually extending its length.

During the first attempt, we can implement the solution using the first approach based on extending the array length.

```Java
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        Deque<Integer> st = new LinkedList<>();

        st.push(0); // Default to put the first element.
        for (int i = 1; i < nums.length * 2; i++) {
            while (!st.isEmpty() && nums[i % nums.length] > nums[st.peek()]) {
                result[st.peek()] = nums[i% nums.length];
                st.pop();
            }
            st.push(i % nums.length);
        }
        return result;
    }
}
```





















