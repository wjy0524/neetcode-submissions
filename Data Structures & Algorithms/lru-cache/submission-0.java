class LRUCache {

    class Node{
        int key;
        int val;
        Node prev;
        Node next;
        //constructor
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    //fields
    private final int capacity;
    //get 이랑 put 할때 필요
    //value는 노드여야함 왜냐하면 이게 여기서 사용한 노드를 가장 맨 앞으로 옮겨야하니까
    Map<Integer, Node> lruMap;
    //arbitrary linkedlist의 시작점과 끝점
    Node start;
    Node end;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.lruMap = new HashMap<>();
        //head랑 tail도 만들어준다
        //따로 만들어야하는 이유는 가장 최근 사용한 node와 가장 늦게 사용한 node를 찾는데 쉽다
        //simply do start.next: 가장 최근 사용한 Node end.prev = 가장 사용한지 오래된 node
        this.start = new Node(0, 0);
        this.end = new Node(0, 0);
        //둘 연결
        start.next = end;
        end.prev = start;
    }
    
    public int get(int key) {
        if(!lruMap.containsKey(key)){
            return -1;
        }
        Node curNode = lruMap.get(key);
        
        renewing(curNode);

        return curNode.val;
    }
    
    public void put(int key, int value) {
        if(lruMap.containsKey(key)){
            //이미 있으면 value만 업뎃
            Node node = lruMap.get(key);
            node.val = value;
            //앞으로 이동
            renewing(node);
        }else{
            //없다면 새로 만들어야함
            Node newNode = new Node(key, value);
            lruMap.put(key, newNode);
            //앞에만 연결
            //앞에랑 붙이기
            Node temp = start.next;
            start.next = newNode;
            newNode.prev = start;
            //뒤에에랑 붙이기
            newNode.next = temp;
            temp.prev = newNode;
            
        }

        //용량 초과인지 확인
        if(lruMap.size() > capacity){
            Node oldestNode = end.prev;
            //없애기
            oldestNode.prev.next = oldestNode.next;
            oldestNode.next.prev = oldestNode.prev;    
            //맵에서도 없애기  
            lruMap.remove(oldestNode.key);    
        }
    }  

    public void renewing(Node curNode){
        //이제 노드를 가장 앞으로 옮겨야함 in LinkedList
        //해야할것:
        //중간에 있을 이 노드를 끊는다
        //끊은 이 노드를 가장 앞에 가져와서 붙인다
        //끊는 것
        curNode.prev.next = curNode.next;
        curNode.next.prev = curNode.prev;

        //붙이는것
        //앞에랑 붙이기
        Node temp = start.next;
        start.next = curNode;
        curNode.prev = start;
        //뒤에에랑 붙이기
        curNode.next = temp;
        temp.prev = curNode;    
    }
}
