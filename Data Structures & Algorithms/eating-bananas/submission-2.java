class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int n = piles.length;
        int right = piles[n-1];
        int left = 1; 
        int ans = right;
        
        while(left <= right){
            int mid = (left+right) / 2;
            long currSum = 0;

            for(int pile : piles){
                currSum += Math.ceil((double) pile / mid);
            }

            if(currSum <= h){
                ans = mid;
                right = mid-1;
            }else
                left = mid+1;
        
        }
        return ans;
    }
}
