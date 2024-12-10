package Day28;

import java.util.Arrays;

public class KNegations {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        // Negate the negative number first.
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < 0 && k > 0){
                nums[i] *= -1;
                k--;
            }
        }
       // If there exists k remained, negate the minimal positive number.
        if(k % 2 == 1){
            Arrays.sort(nums);
          nums[0] = - nums[0];
                }
        int result = 0;
        for(int i: nums){
            result += i;
        }
        return result;
    }
}
