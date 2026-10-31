class Solution {
    public void dfs(int[] nums, int target, int index, List<Integer> list,  List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }

        if(target < 0 || nums.length == index) 
            return;

        for (int i = index; i < nums.length; i++) {
            if (nums[i] > target) {
                break;
            }

            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            list.add(nums[i]);
            dfs(nums, target-nums[i], i+1, list, ans);

            list.remove(list.size() - 1);

            //dfs(nums, target, index+1, list, ans);
        }
    }

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        dfs(nums, target, 0, list, ans);

        return ans;
    }
}
