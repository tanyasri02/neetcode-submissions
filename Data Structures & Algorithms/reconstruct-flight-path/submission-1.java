class Solution {
    HashMap<String, PriorityQueue<String>> graph = new HashMap<>();
    List<String> ans = new ArrayList<>();

    public void dfs(String curr){

        while(graph.containsKey(curr)  && !graph.get(curr).isEmpty()){
            String next = graph.get(curr).poll();
            dfs(next);
        }

        ans.add(curr);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        // build graph

        for(List<String> ticket : tickets){
            String from = ticket.get(0);
            String to = ticket.get(1);

            graph.putIfAbsent(from, new PriorityQueue<>());
            graph.get(from).add(to); // we can lexicographically sort the ticket
        }

        dfs("JFK");

        Collections.reverse(ans);
        return ans;
    }
}
