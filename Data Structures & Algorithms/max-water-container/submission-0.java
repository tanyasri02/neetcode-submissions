class Solution {
    public int maxArea(int[] heights) {
        int i=0;
        int j=heights.length-1;
        int ans = 0;

        while(i < j){
            ans = Math.max(ans, Math.min(heights[i], heights[j]) * (j-i));

            if(heights[i] < heights[j])
                i++;
            else
                j--;
        }

        return ans;
    }
}
