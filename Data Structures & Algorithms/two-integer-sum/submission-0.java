class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer>mp = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int curr = target - nums[i];
            if(mp.containsKey(curr))
                return new int[] {mp.get(curr), i};

            mp.put(nums[i], i);
        }

        return new int[] {};
    }
}
