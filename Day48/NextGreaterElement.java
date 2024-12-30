package Day48;

import java.util.*;

public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Arrays.fill(result, -1);
        Deque<Integer> st = new LinkedList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        if(nums1.length == 0) return result;
        // Put elements of nums1 into the hashMap.
        for (int i = 0; i < nums1.length; i++) {
            hashMap.put(nums1[i],i);
        }
        st.push(0);
        for (int i = 1; i < nums2.length ; i++) {
            if(nums2[i] <= nums2[st.peek()]){
                    st.push(i);
            }else{
                while(!st.isEmpty() && nums2[i] > nums2[st.peek()]){
                    int index = st.pop();
                    if(hashMap.containsKey(nums2[index])){
                        int resultIndex = hashMap.get(nums2[index]);
                        result[resultIndex] = nums2[i];
                    }
                }
                st.push(i);
            }
        }
        return result;
    }
}
