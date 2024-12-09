package Day27;

public class WiggleSequence {
    public int wiggleMaxLength(int[] nums) {
        int count = 1;
        int preDiff = 0;
        int curDiff;
        if(nums.length == 1) return 1;
        for (int i = 0; i < nums.length -1; i++) {
            curDiff = nums[i+1] - nums[i];
            if((preDiff >= 0 && curDiff < 0) || (preDiff <= 0 && curDiff > 0)){
                count++;
                preDiff = curDiff;
            }
        }
        return count;
    }
}
