package Day49;

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
