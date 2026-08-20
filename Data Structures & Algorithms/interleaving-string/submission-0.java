class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        int k = s3.length();

        if(n+m != k)
            return false;

        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;

        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                int x = i+j-1;

                if(i > 0 && s1.charAt(i-1) == s3.charAt(x)){
                    dp[i][j] |= dp[i-1][j]; 
                }
                if(j>0 && s2.charAt(j-1) == s3.charAt(x)){
                    dp[i][j] |= dp[i][j-1];  
                }
            }
        }
        return dp[n][m];
    }
}
