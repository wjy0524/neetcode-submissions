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

//deep copy instead of shallow copy

class Solution {
    //key: original node, value: copied node
    Map<Node, Node> copy;

    public Node dfsClone(Node startNode){
        if(copy.containsKey(startNode)){
            //if it has always been cloned, no need to clone it again, just simply return copied node
            return copy.get(startNode);
        }

        Node copiedNode = new Node(startNode.val);
        //hasmap에 저장
        copy.put(startNode, copiedNode);

        copiedNode.neighbors = new ArrayList<>();
        for(int idx=0; idx<startNode.neighbors.size(); idx++){
            Node copiedNeigh = dfsClone(startNode.neighbors.get(idx));
            copiedNode.neighbors.add(copiedNeigh);
        }

        return copiedNode;
    }

    public Node cloneGraph(Node node) {
        //if node is null then return null
        if(node == null){
            return null;
        }
        copy = new HashMap<>();
        return dfsClone(node);
        
    }
}