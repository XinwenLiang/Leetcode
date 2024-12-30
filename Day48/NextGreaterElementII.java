package Day48;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

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
