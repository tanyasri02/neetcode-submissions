class Solution {
    boolean dfs(List<List<Integer>>graph, boolean[] vis, int curr, int parent){
        vis[curr] = true;

        for(int neighbour : graph.get(curr)){
            if(vis[neighbour]){
                if(neighbour != parent)
                    return true;
            }
            else{
                if(dfs(graph, vis, neighbour, curr))
                    return true;
            }
        }

        return false;
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<List<Integer>>graph = new ArrayList<>();

        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);

            boolean[] visit = new boolean[n+1];

            if(dfs(graph, visit, u, -1))
                return edge;
        }

        return new int[0];
    }
}
