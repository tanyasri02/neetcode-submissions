class Solution {
    public int isSubset(int[] coins, int amount){
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];

        dp[0][0] = 1;

        for(int i=1;i<=n;i++){
            for(int j=0;j<=amount;j++){
                if(coins[i-1] > j)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-coins[i-1]];
            }
        }

        return dp[n][amount];
    }
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num: nums){
            sum+= num;
        }

        if((sum + target) % 2 != 0 || Math.abs(target) > sum) return 0;
        return isSubset(nums, (sum+target)/2);
    }
}
