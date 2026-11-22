/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;

        Map<Node, Node> mp = new HashMap<>();

        Node curr = head;

        while(curr != null){
            mp.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;

        while(curr != null){
            Node copy = mp.get(curr);

            if(curr.next != null){
                copy.next = mp.get(curr.next);
            }

            if(curr.random != null){
                copy.random = mp.get(curr.random);
            }
            curr = curr.next;
        }

        return mp.get(head);
    }
}
