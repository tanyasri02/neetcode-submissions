class Solution {
    public int maxSubArray(int[] nums) {
        int currSum = 0, totalSum = nums[0];

        for(int num: nums){
            if(currSum < 0)
                currSum = 0;

            currSum += num;
            totalSum = Math.max(totalSum, currSum);
        }

        return totalSum;
    }
}
