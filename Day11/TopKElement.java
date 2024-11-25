package Day11;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKElement {
    public int[] topKFrequent(int[] nums, int k){
        Map<Integer,Integer> map = new HashMap<>();
        for(int num :nums){
            map.put(num, map.getOrDefault(num,0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1,pair2) -> pair1[1] -pair2[1]);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(pq.size() < k){
                pq.add(new int[]{entry.getKey(), entry.getValue()});
            }else{
                if (entry.getValue() > pq.peek()[1]) {
                    pq.poll(); // Pop the root node.
                    pq.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }
        int[] result = new int[k];
        for (int i = k-1; i >=0 ; i--) {
            result[i] = pq.poll()[0];
        }
        return result;
    }
}
