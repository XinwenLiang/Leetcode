package Day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSums {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] > target && nums[k] > 0 && target > 0) {
                break; //First level pruning operation.
            }
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue; // First level deduplication operation.
            }
            for (int i = k + 1; i < nums.length; i++) {
                int sum1 = nums[i] + nums[k];
                if (sum1 > target && sum1 > 0 && target > 0) {
                    break; // Second level pruning operation.
                }
                if (i > k + 1 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int sum = 0;
                int left = i + 1;
                int right = nums.length - 1;
                while (right > left) {
                    sum = nums[k] + nums[i] + nums[right] + nums[left];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        result.add(Arrays.asList(nums[k], nums[i], nums[left], nums[right]));
                        while (right > left && nums[right] == nums[right - 1]) right--;
                        while (right > left && nums[left] == nums[left + 1]) left++;

                        right--;
                        left++;
                    }
                }
            }
        }
        return result;
    }
}
