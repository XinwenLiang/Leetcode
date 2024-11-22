package Day6;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // Create a hash map to store the elements we have iterated.
        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int balance = target - nums[i]; // Calculate the element we want to look up.
            if(indexMap.containsKey(balance)){
                return new int[] {i, indexMap.get(balance)};
            }else{
                // If fails to find a corresponding element, store its information in the map.
                indexMap.put(nums[i], i);
            }
        }
        return null;
    }
}
