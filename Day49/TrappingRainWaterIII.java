package Day49;

import java.util.Deque;
import java.util.LinkedList;

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
