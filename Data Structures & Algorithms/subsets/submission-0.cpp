class Solution {
public:
    void subset(vector<int>nums, int i, int n, vector<vector<int>>& ans, vector<int>&subsets){
        if(i >= n){
            ans.push_back(subsets);
            return;
        }

        subsets.push_back(nums[i]);
        subset(nums, i+1, n , ans, subsets);
        subsets.pop_back();
        subset(nums, i+1, n, ans, subsets);

        
    }
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>>ans;
        vector<int>subsets;
        int n = nums.size();

        subset(nums, 0, n, ans, subsets);
        return ans;
    }
};
