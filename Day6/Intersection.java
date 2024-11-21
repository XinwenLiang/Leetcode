package Day6;

import java.util.ArrayList;
import java.util.List;

public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] hash1 = new int[1002];
        int[] hash2 = new int[1002];
        // Count the frequency of every number in nums1.
        for(int i : nums1){
            hash1[i] ++;
        }
        // Count the frequency of every number in nums2.
        for(int i : nums2){
            hash2[i] ++;
        }

        // Define a list to store the intersection of nums1 and nums2.
        List<Integer> result = new ArrayList<>();

        // Check if there exists intersection.
        for (int i = 0; i < 1002; i++) {
            if(hash1[i] > 0 && hash2[i] >0){
                result.add(i);
            }
        }
        // Transform the list to the array.
        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }
}
