class LRUCache {

    //cache class
    class Cache{
        int key;
        int val;
        Cache next;
        Cache prev;

        //constructor
        Cache(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    //fields
    private final int capacity;
    private Map<Integer, Cache> map;
    Cache head;
    Cache tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = new Cache(0, 0);
        tail = new Cache(0, 0);

        head.next = tail;
        tail.prev = head;

    }
    
    public int get(int key) {
        if(!map.containsKey(key))return -1;

        Cache curCache = map.get(key);

        renew(curCache);

        return curCache.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Cache cur = map.get(key);
            cur.val = value;
            renew(cur);
        }else{
            Cache newCache = new Cache(key, value);
            addIntoHead(newCache);
            map.put(key, newCache);
        }

        if(map.size() > capacity){    
            Cache oldest = tail.prev;
            disconnect(oldest);
            map.remove(oldest.key);
        }
    }


    public void disconnect(Cache curCache){
        curCache.prev.next = curCache.next;
        curCache.next.prev = curCache.prev;
    }

    public void addIntoHead(Cache curCache){
        curCache.next = head.next;
        curCache.next.prev = curCache;
        head.next = curCache;
        curCache.prev = head;
    }

    public void renew(Cache curCache){
        disconnect(curCache);
        addIntoHead(curCache);
    }
}
