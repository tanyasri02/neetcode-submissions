class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        int x = 0;
        int[] ans = new int[n-k+1]; // because we want last k windows

        for(int i=0;i<n;i++){
            if(!dq.isEmpty() && dq.peekFirst() <= i-k)
                dq.pollFirst();
             // this is out of our window

            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) // since the number is smaller they are of no use
                dq.pollLast(); 

            dq.add(i);

            if(i >= k-1)
                ans[i-k+1] = nums[dq.peekFirst()];
        }

        return ans;
    }
}
