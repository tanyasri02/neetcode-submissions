class Solution {
    public void dfs(List<List<Integer>>graph, boolean[] vis, int curr){
        vis[curr] = true;

        for(int nei : graph.get(curr)){
            if(!vis[nei])
                dfs(graph, vis, nei);
        }
    }
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>>graph = new ArrayList<>();

        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] vis = new boolean[n];
        int ans = 0;

        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(graph, vis, i);
                ans++;
            }
        }

        return ans;
    }
}
