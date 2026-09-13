/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// PQ approach

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null; // nullPointerException handle kar liya

        ListNode dummy = new ListNode(0);
        ListNode current = dummy; // relinking thaki memory leak no ho

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.val, b.val));// important because you can have [], [1,2]

        for(ListNode list:lists){
            if(list != null){
                pq.add(list);
            } // skip []
        }

        while(!pq.isEmpty()){
            ListNode smallestNode = pq.poll();
            current.next = smallestNode;
            current = current.next;

            if(smallestNode.next != null)
                pq.add(smallestNode.next);
        }
        return dummy.next;
    }
}

// 0(nlogm)
// 0(k)

 // can solve it with divide and conqure approach also
 // do do list to merge karte jao
