package Day49;

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
