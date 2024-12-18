package Day36;

public class OneAndZero {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][]dp = new int[m+1][n+1];
        int x; // Record the number of 0's
        int y; // Record the number of 1's
        for(String str:strs){
            x = 0;
            y = 0;
            for(char ch :str.toCharArray()){
                if(ch == '0'){
                    x++;
                }else{
                    y++;
                }
            }
            for (int i = m; i >= x; i--) {
                for (int j = n; j >= y ; j--) {
                    dp[i][j]= Math.max(dp[i][j], dp[i-x][j-y] + 1);
                }

            }
        }
        return dp[m][n];
    }
}
