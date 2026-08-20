class Solution {
    public int helper(int[][] matrix, int i, int j, int hei, int n, int m, int[][] dp)  {
        if(dp[i][j] != 0)
            return dp[i][j];

        int mx = 1;

        if(i>0 && matrix[i][j] < matrix[i-1][j])
            mx = Math.max(mx,1 + helper(matrix, i-1, j, hei+1, n, m, dp));
        if(j>0 && matrix[i][j] < matrix[i][j-1])
           mx = Math.max(mx, 1+ helper(matrix, i, j-1, hei+1, n, m, dp));
        if(i<n-1 && matrix[i][j] < matrix[i+1][j])
            mx = Math.max(mx, 1+ helper(matrix, i+1, j, hei+1, n , m, dp));
        if(j<m-1 && matrix[i][j] < matrix[i][j+1])
            mx = Math.max(mx, 1 + helper(matrix, i, j+1, hei+1, n, m, dp));

        dp[i][j] = mx;
        return mx;
    }

    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ans = 0;
        int[][] dp = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int k = helper(matrix, i, j, 0, n, m, dp);
                ans = Math.max(ans, k);
            }
        }
        return ans;
    }
}
