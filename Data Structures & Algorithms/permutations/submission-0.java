class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void helper(int[] nums, int index){
        if(index == nums.length){
            List<Integer> temp = new ArrayList<>();

            for(int i=0;i<nums.length;i++){
                temp.add(nums[i]);
            }

            ans.add(temp);
        }


        for(int i=index;i<nums.length;i++){
            swap(nums, i, index);
            helper(nums, index+1);
            swap(nums, i, index);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        helper(nums, 0);
        return ans;
    }
}
