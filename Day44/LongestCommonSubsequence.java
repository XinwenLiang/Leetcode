package Day44;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] nums1 = text1.toCharArray();
        char[] nums2 = text2.toCharArray();
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        // Initialize the dp array.
        for (int i = 0; i < nums1.length + 1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < nums2.length + 1; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i < nums1.length + 1; i++) {
            for (int j = 1; j < nums2.length + 1; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[nums1.length][nums2.length];
    }
}
