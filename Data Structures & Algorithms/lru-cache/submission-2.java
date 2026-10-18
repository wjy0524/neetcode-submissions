class LRUCache {

    class Node{
        int key;
        int val;
        Node prev;
        Node next;

        //construtor
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    //fields
    private final int capacity;
    private Map<Integer, Node> lruMap;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        lruMap = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!lruMap.containsKey(key)) return -1;

        Node curNode = lruMap.get(key);
        renew(curNode);
        return curNode.val;
    }
    
    public void put(int key, int value) {
        if(lruMap.containsKey(key)){
            Node curNode = lruMap.get(key);
            curNode.val = value;
            renew(curNode);
        }else{
            Node newNode = new Node(key, value);
            moveToHead(newNode);
            lruMap.put(key, newNode);
        }

        if(lruMap.size() > capacity){
            Node lastNode = tail.prev;
            remove(lastNode);
            lruMap.remove(lastNode.key);
        }
    }

    public void remove(Node cur){
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
    }

    public void moveToHead(Node cur){
        cur.next = head.next;
        cur.next.prev = cur;
        head.next = cur;
        cur.prev = head;
    }

    public void renew(Node cur){
        remove(cur);
        moveToHead(cur);
    }
}
