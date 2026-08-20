class Solution {
public:
    int trap(vector<int>& height) {
        int ans = 0;
        int n = height.size();
        if(n == 1)
            return 0;

        int leftmax = height[0], i = 0, rightmax = height[n-1], j = n-1;
        
        while(i<j){
            if(leftmax <= rightmax){
                ans += leftmax - height[i];
                i++;
                leftmax = max(leftmax, height[i]);
            }
            else{
                ans += rightmax - height[j];
                j--;
                rightmax = max(rightmax, height[j]);
            }
        }
        return ans;

    }
};
