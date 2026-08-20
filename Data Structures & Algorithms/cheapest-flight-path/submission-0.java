class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int len = flights.length;
        List<int[]>[] graph = new ArrayList[n];

        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }


        for(int i=0;i<len;i++){
            int u = flights[i][0];
            int v = flights[i][1];
            int cost = flights[i][2];

            graph[u].add(new int[]{v, cost});
        }

        int [] dist = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{src, 0, -1}); // src, dist, stops

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int node = curr[0];
            int cost = curr[1];
            int stops = curr[2];

            for(int[] edge : graph[node]){
                int v = edge[0];
                int currCost = edge[1];

                if(currCost + cost < dist[v] && stops+1 <= k){
                    dist[v] = currCost + cost;
                    q.offer(new int[]{v, dist[v], stops+1});
                }
            }
        }

        if(dist[dst] == Integer.MAX_VALUE)
            return -1;

        return dist[dst];
    }
}
