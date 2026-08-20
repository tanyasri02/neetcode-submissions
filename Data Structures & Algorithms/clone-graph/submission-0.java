/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node, Node> mp = new HashMap<>();

    public Node cloneGraph(Node node) {
        // nde copy --> Node <> neigh
        if(node == null)
            return node;
            
        if(mp.get(node) != null )
            return mp.get(node);

        Node newRoot = new Node(node.val); 
        mp.put(node, newRoot); 

        for(Node nei : node.neighbors) {
            Node child = cloneGraph(nei);
            newRoot.neighbors.add(child);
        }
        return newRoot;
    }
}