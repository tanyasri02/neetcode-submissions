class Solution {
    boolean hasCycle(List<List<Integer>> graph, boolean[] vis, int curr, int parent){
        vis[curr] = true;

        for (int neighbor : graph.get(curr)) {
            if (neighbor == parent) continue;

            if (vis[neighbor]) return true;

            if (hasCycle(graph, vis, neighbor, curr)) return true;
        }

        return false;
    }
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] vis = new boolean[n];

        if (hasCycle(graph, vis, 0, -1)) 
            return false;

        for(boolean v : vis){
            if(!v)
                return false;
        }

        return true;
            
    }
}
