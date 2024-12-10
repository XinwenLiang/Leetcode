package Day28;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int cover = 0;
        if(nums.length == 1){
            return true;
        }
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(i+ nums[i], cover);
            if(cover >= nums.length - 1) return true;
        }
        return false;
    }
}
