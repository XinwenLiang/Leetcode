package Day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSums {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        // Look up a+b+c=0, a = nums[i], b = nums[left], c = nums[right]
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0){
                return result;
            }
            if(i > 0 && nums[i]==nums[i-1]){// Remove the duplicate result for a.
                continue;
            }
            int left = i +1;
            int right = nums.length -1;
            while(right > left){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum> 0){ // If a+b+c>0, that means we need to reduce the sum.
                    right--;
                }else if(sum< 0){// If a+b+c<0, that means we need to increase the sum.
                    left ++;
                }else{
                    result.add(Arrays.asList(nums[i], nums[left],nums[right]));
                    // Remove the duplicate b and c.
                    while(right > left && nums[right] == nums[right-1]) right --;
                    while(right > left && nums[left] == nums[left+1]) left++;

                    right--;
                    left++;
                }
            }
        }
        return result;
    }
}
