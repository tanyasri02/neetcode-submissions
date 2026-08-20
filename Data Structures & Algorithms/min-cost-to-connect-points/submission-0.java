class DSU{
    int[] Parent, Rank;

    public DSU(int n){
        Parent = new int[n+1];
        Rank = new int[n+1];

        for(int i=0;i<=n;i++){
            Parent[i] = i;
        }

        Arrays.fill(Rank, 1);
    }


    public int find(int node){
        if(Parent[node] != node)
            Parent[node] = find(Parent[node]);
        
        return Parent[node];
    }

    public boolean union(int u,  int v){
        int pOfu = find(u);
        int pOfv = find(v);

        if (pOfu == pOfv) return false;

        if(Rank[pOfu] < Rank[pOfv]){
            int temp = pOfu;
            pOfu = pOfv;
            pOfv = temp;
        }

        Rank[pOfu] += Rank[pOfv];
        Parent[pOfv] = pOfu;

        return true;
    }
}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        DSU dsu = new DSU(n);

        List<int[]> edges = new ArrayList<>();

        // Build a graph
        for(int i=0;i<n;i++){
            for(int j=i+1; j<n; j++){
                int dist = Math.abs(points[i][0] - points[j][0]) + 
                           Math.abs(points[i][1] - points[j][1]);

                edges.add(new int[] {dist, i, j});
            }
        }

        edges.sort((a, b) -> Integer.compare(a[0], b[0]));

        int ans = 0;

        for(int[] edge: edges){
            if(dsu.union(edge[1], edge[2]))
                ans += edge[0];
        }

        return ans;
    }
}

 