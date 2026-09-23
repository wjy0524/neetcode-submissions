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
    //key = 원본 노드 value = 복사 노드
    Map<Node, Node> visited;
    public Node drawGraph(Node startNode){
        //base case
        //if node is already visited then stop
        //이미 복사 한 노드면 즉 startNode가 Key로 존재하면
        //새로 똑 복사 하지 말고 이미 복사 한 노드를 return 한다
        if(visited.containsKey(startNode)){
            return visited.get(startNode);
        }

        //지금 노드를 복사해야지
        Node copiedNode = new Node(startNode.val);
        //HashMap에 저장
        visited.put(startNode, copiedNode);
        //neighbord iterating
        for(int idx = 0; idx < startNode.neighbors.size(); idx++){
            Node neighNode = startNode.neighbors.get(idx);
            Node copiedNeigh = drawGraph(neighNode);
            copiedNode.neighbors.add(copiedNeigh);
        }

        return copiedNode;

    }

    public Node cloneGraph(Node node) {
        if(node == null) return null;
        visited = new HashMap<>();
        drawGraph(node);
        return visited.get(node);
    }
}