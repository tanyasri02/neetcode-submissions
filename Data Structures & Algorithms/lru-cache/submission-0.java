class Node{
    int key;
    int value;
    Node next;
    Node prev;

    Node(int key, int value){
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}
class LRUCache {
    int limit;
    Map<Integer, Node> mp;
    Node head;
    Node tail;

    public void addNode(Node newNode){
        Node oldNext = head.next;
        head.next = newNode;
        newNode.next = oldNext;
        newNode.prev = head;
        oldNext.prev = newNode;
    }

    public void delNode(Node node){
        Node oldPrev = node.prev;
        Node oldNext = node.next;

        oldPrev.next = oldNext;
        oldNext.prev = oldPrev;
    }

    public LRUCache(int capacity) {
        this.limit = capacity;
        this.mp = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);

        this.head.next = tail;
        this.tail.prev = head;
    }
    
    public int get(int key) {
        if(!mp.containsKey(key))
            return -1;

        Node ansNode = mp.get(key); // 0(1)
        int ans = ansNode.value;

        delNode(ansNode);
        addNode(ansNode);

        return ans;
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)){
            Node oldNode = mp.get(key);
            delNode(oldNode);
            mp.remove(key);
        }else if(mp.size() == limit){
            Node oldNode = tail.prev;
            mp.remove(oldNode.key);
            delNode(oldNode);
        }

        Node newNode = new Node(key, value);
        addNode(newNode);
        mp.put(key, newNode);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */