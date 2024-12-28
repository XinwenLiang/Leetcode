package Day45;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        char[] nums1 = word1.toCharArray();
        char[] nums2 = word2.toCharArray();
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 0; i <= nums1.length; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= nums2.length ; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= nums1.length ; i++) {
            for (int j = 1; j <= nums2.length ; j++) {
                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j]+1,dp[i][j-1]+1),dp[i-1][j-1]+1);
                }
            }
        }
        return dp[nums1.length][nums2.length];
    }
}
