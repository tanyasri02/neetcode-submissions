class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();

        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){
            int l = i+1;
            int r = nums.length-1;

            while(l<r){
                int curr = nums[i] + nums[l] + nums[r];

                if(curr < 0)   
                    l++;
                else if(curr > 0)
                    r--;
                else {
                    List<Integer>tmp = Arrays.asList(nums[i], nums[l], nums[r]);
                    ans.add(tmp);
                    l++; r--;

                    while(l<r && nums[l] == nums[l-1])
                        l++;
                }
            }
        }

        return new ArrayList<>(ans);
    }
}
