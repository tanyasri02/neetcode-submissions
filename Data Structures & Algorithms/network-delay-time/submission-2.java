class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new ArrayList[101];

        for(int i=0;i<101;i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] time: times){
            int u = time[0];
            int v = time[1];
            int wt = time[2];

            graph[u].add(new int[]{v, wt});
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(k);

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;

        while(!q.isEmpty()){
            int curr = q.poll();

            for(int[] neig : graph[curr]){
                int v = neig[0];
                int wt = neig[1];
                if (dist[curr] == Integer.MAX_VALUE) {
                    continue;
                }

                int currWt = dist[curr] + wt;
                if(dist[v] > currWt){
                    dist[v] = currWt;
                    q.add(v);
                }
            }
        }

        int ans = 0;

        for(int i=1;i<=n;i++){
            ans = Math.max(ans, dist[i]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
