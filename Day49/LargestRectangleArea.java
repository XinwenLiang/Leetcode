package Day49;

import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangleArea {
    int largestRectangleArea(int[] heights) {
        int[] height = new int[heights.length + 2];
        Deque<Integer> st = new LinkedList<>();
        height[0] = 0;
        height[height.length - 1] = 0;
        System.arraycopy(heights, 0, height, 1, heights.length);
        st.push(0);
        int result = 0;
        for (int i = 1; i < height.length ; i++) {
            if(height[i] > height[st.peek()]){
                st.push(i);
            }else{
                while(!st.isEmpty() && height[i] < height[st.peek()]){
                    int mid = st.peek();
                    st.pop();
                    if(! st.isEmpty()) {
                        int left = st.peek();
                        int h = height[mid];
                        int w = i - left - 1;
                        result = Math.max(result, h*w);
                    }
                }
                st.push(i);
            }
        }
        return result;
    }
}
