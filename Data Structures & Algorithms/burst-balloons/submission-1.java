class Solution {
    public int fun(int[] nums, int left, int right, int[][] dp){
        if(left > right)
            return 0;

        if(dp[left][right] != 0)
            return dp[left][right];

        int ans = 0;

        for(int i=left+1;i<right;i++){
            int curr = nums[left]*nums[i]*nums[right];
            ans = Math.max(ans, curr + fun(nums, left, i, dp) + fun(nums, i, right, dp));
        }
        return dp[left][right] = ans;
    }
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+2];
        arr[0] = 1;
        arr[n+1] = 1;
        int j=1;
        int [][] dp = new int [n+2][n+2];

        for(int i=0;i<n;i++){
            arr[j] = nums[i];
            j++;
        }

        return fun(arr, 0, nums.length+1, dp);
    }
}
