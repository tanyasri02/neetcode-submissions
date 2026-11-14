class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int x = 0;
        int[] ans = new int[k];

        for(int num:nums)
            mp.put(num, mp.getOrDefault(num, 0) + 1);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0] - b[0]));

        for(var entry : mp.entrySet()){
            pq.add(new int[]{entry.getValue(), entry.getKey()});
            if(pq.size() > k)
                pq.poll();
        }

        for(int i=0;i<k;i++){
            int[] curr = pq.poll();
            ans[i] = curr[1];
        }

        return ans;
    }
}
