class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];
        if(n == 1)
            return 0;

        dp[0] = 0;
        dp[1] = Math.max(dp[0], prices[1]-prices[0]);

        for(int i=2;i<n;i++){
            int mx = 0;
            for(int j=i-1; j>=0; j--){
                int curr = prices[i] - prices[j] + (j <= 2 ? 0 : dp[j-2]);
                mx = Math.max(mx, curr);
            }
            dp[i] = Math.max(dp[i-1], mx);
        }

        return dp[n-1]; 
    }
}
