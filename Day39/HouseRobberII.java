package Day39;

public class HouseRobberII {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int len = nums.length;
        return Math.max(robAction(nums,0, len-1), robAction(nums,1, len));
    }
    int robAction(int[] nums, int start, int end){
        int temp1 = 0;
        int temp2 = 0;
        int result = 0;
        for (int i = start; i < end; i++) {
            temp1 = result;
            result = Math.max(temp2 + nums[i], temp1);
            temp2 = temp1;
        }
        return result;
    }
}
