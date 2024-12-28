package Day45;

public class DistinctSequences {
    public int numDistinct(String s, String t) {
        char[] nums1 = s.toCharArray();
        char[] nums2 = t.toCharArray();
        int [][] dp = new int[nums1.length +1][nums2.length + 1];
        // Initialize the dp array.
        dp[0][0] = 1;
        for (int i = 0; i < nums1.length + 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < nums1.length +1; i++) {
            for (int j = 1; j < nums2.length +1; j++) {
                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[nums1.length][nums2.length];
    }
}
