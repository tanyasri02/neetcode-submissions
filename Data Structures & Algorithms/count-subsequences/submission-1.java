class Solution {
    public int helper(String s, String t, int i , int j, int n, int m, int[][] dp){

        if(j >= m)
            return 1;

        if(i>=n)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];

        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] = helper(s, t, i+1, j+1, n, m, dp) + helper(s, t, i+1, j, n, m, dp);
        }
        return dp[i][j] = helper(s, t, i+1, j, n, m, dp);
    }
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int dp[][] = new int[n][m];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i], -1);

        return helper(s, t, 0, 0, n, m, dp);
    }
}
