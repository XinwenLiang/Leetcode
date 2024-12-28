package Day46;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        char[] t = s.toCharArray();
        int res = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = t.length - 1; i >= 0; i--) {
            for (int j = i; j < t.length; j++) {
                if (t[i] == t[j]) {
                    if (j - i <= 1) {
                        dp[i][j] = true;
                        res++;
                    } else if (i + 1 <= j - 1 && dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
