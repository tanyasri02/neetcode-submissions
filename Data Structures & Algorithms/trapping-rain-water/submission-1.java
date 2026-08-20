class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int i = 0, j = height.length -1;
        int leftmax = height[0], rightmax = height[j];

        while(i<j){
            if(leftmax <= rightmax){
                ans += leftmax - height[i];
                i++;
                leftmax = Math.max(height[i], leftmax);
            }else{
                ans += rightmax - height[j];
                j--;
                rightmax = Math.max(height[j], rightmax);
            }
        }

        return ans;

    }
}
