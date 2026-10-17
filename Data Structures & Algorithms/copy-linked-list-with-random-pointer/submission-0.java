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
        //가지치기
        if(head == null) return null;

        //hashmap: key: og node, val: copied node 
        Map<Node, Node> nodeMap = new HashMap<>();
        
        //iterate through each node to copy node
        Node cur = head;
        while(cur != null){
            nodeMap.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;
        while(cur != null){
            Node copiedCur = nodeMap.get(cur);
            copiedCur.next = nodeMap.get(cur.next);
            copiedCur.random = nodeMap.get(cur.random);
            cur = cur.next;
        }
        
        return nodeMap.get(head);
    }
}
