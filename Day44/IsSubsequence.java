package Day44;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        char[] nums1 = s.toCharArray();
        char[] nums2 = t.toCharArray();
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 1; i <= nums1.length ; i++) {
            for (int j = 1; j <= nums2.length ; j++) {
                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[nums1.length][nums2.length] == nums1.length;
    }
}
