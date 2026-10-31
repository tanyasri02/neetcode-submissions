class Solution {
    public void dfs(int[] nums, int target, int index, List<Integer> list,  List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }

        if(target < 0 || nums.length == index) 
            return;

        list.add(nums[index]);
        dfs(nums, target-nums[index], index, list, ans);

        list.remove(list.size() - 1);

        dfs(nums, target, index+1, list, ans);
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        dfs(nums, target, 0, list, ans);

        return ans;
    }
}
