class Solution {
    boolean isSubset(int[] nums, int target) {
        int n = nums.length;

        boolean[][] dp = new boolean[n + 1][target + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {

                if (j < nums[i - 1]) 
                    dp[i][j] = dp[i - 1][j];
                else 
                    dp[i][j] = dp[i - 1][j]|| dp[i - 1][j - nums[i - 1]];
                
            }
        }

        return dp[n][target];
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;

        for(int i=0;i<n;i++){
            sum += nums[i];
        }

        if(sum % 2 != 0)
            return false;

        return isSubset(nums, sum/2);
    }
}
