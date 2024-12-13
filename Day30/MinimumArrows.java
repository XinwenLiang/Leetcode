package Day30;

import java.util.Arrays;

public class MinimumArrows {
    public int findMinArrowShots(int[][] points){
        if(points == null) return 0;
        Arrays.sort(points, (a,b) -> Integer.compare(a[0],b[0]));
        int result =1;
        for (int i = 1; i < points.length; i++) {
            if(points[i][0] > points[i-1][1]){
                result++;
            }else{
                points[i][1] = Math.min(points[i-1][1], points[i][1]);
            }
        }
        return result;
    }
}
