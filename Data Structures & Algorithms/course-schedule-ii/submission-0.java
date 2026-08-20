class Solution {
    boolean hasCycle(List<List<Integer>> graph, boolean[] vis, boolean[] visPath, int i, List<Integer> output){
        if(visPath[i])
            return true;
        
        if(vis[i])
            return false;

        vis[i] = true;
        visPath[i] = true;

        for(int next : graph.get(i)){
            if(hasCycle(graph, vis, visPath, next, output))
                return true;
        }

        visPath[i] = false;
        output.add(i);
        return false;
    } 

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            graph.get(edge[0]).add(edge[1]);
        }

        boolean[] vis = new boolean[numCourses];
        boolean[] visPath = new boolean[numCourses];
        List<Integer> output = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            if(hasCycle(graph, vis, visPath, i, output))
                return new int[0];
        }

        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = output.get(i);
        }

        return result;
    }
}
