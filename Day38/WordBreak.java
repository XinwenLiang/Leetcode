package Day38;

import java.util.HashSet;
import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        for(int i=1; i<=s.length(); i++){
            for (int j = 0; j < i; j++) {
                if(set.contains(s.substring(j,i)) && dp[j]){
                    dp[i] = true;
                }
            }
        }
        return dp[len];
    }
}
