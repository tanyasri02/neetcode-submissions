class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        boolean[][] dp = new boolean[n+1][n+1];
        if(n == 1)
            return 1;

        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(s.charAt(i) == s.charAt(j) && (j-i <= 2 || dp[i+1][j-1])){
                    ans++;
                    dp[i][j] = true;
                }
            }
        }
        return ans;
    }
}
