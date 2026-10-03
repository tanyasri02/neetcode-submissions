class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if(n <= 2)
            return 0;
            
        int left = 0,  right = n-1;
        int ans = 0;

        int leftMax = height[0], rightMax = height[n-1];

        while(left < right){
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);

            if(leftMax < rightMax){
                ans += leftMax - height[left];
                left++;
            }else{
                ans += rightMax - height[right] ;
                right--;
            }
        }

        return ans;
    }
}
