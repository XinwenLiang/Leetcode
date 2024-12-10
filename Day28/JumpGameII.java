package Day28;

public class JumpGameII {
    public int jump(int[] nums) {
        int cur = 0;
        int next = 0;
        int result = 0;
        if (nums.length == 1) return 0;
        for (int i = 0; i < nums.length; i++) {
            next = Math.max(i + nums[i], next);
            // Move to the next step can cover the end point.
            if (next >= nums.length - 1) {
                result++;
                break;
            }
            if (i == cur) {
                cur = next;
                result++;
            }
        }
        return result;
    }
}
