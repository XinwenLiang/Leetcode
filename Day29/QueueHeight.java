package Day29;

import java.util.Arrays;
import java.util.LinkedList;

public class QueueHeight {
    LinkedList<int[]> res = new LinkedList<>();
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a,b) -> {
            if(a[0] == b[0]) return a[1] - b[1]; // If their heights are equal, sort them in ascending order based on k value.
            return b[0] - a[0]; // Otherwise, sort them in descending order based on height.
        });

        for(int[] p : people){
            res.add(p[1],p);
        }
        return res.toArray(new int[people.length][]);
    }
}
