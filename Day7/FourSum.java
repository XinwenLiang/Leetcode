package Day7;

import java.util.HashMap;
import java.util.Map;

public class FourSum {
   public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4){
       int count = 0; // Define a count variable.
       // Define a map to store the sum of a and b.
       Map<Integer, Integer> sumOfTwo = new HashMap<>();
       for (int i : nums1) {
           for(int j : nums2){
               int sum = i+j;
               sumOfTwo.put(sum, sumOfTwo.getOrDefault(sum,0)+1);
           }
       }
       // Look up the target(0-c-d) in the map.
       for(int i : nums3){
           for(int j : nums4){
               int sum2  = i + j;
               int target = 0 - sum2;
               if (sumOfTwo.containsKey(target)){
                   count = count + sumOfTwo.getOrDefault(target, 0);
               }
           }
       }
       return count;
   }
}
