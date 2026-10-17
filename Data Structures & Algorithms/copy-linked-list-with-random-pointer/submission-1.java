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
        if(head == null) return null;

        //HashMap (key: ogNode, val: copiedNode)
        Map<Node, Node> nodeMap = new HashMap<>();

        Node cur = head;
        //this would take O(n) since we iterate through n length linkedlist
        while(cur != null){
            nodeMap.put(cur, new Node(cur.val));
            cur = cur.next;
        }   

        cur = head;
        while(cur != null){
            Node curCopy = nodeMap.get(cur);
            curCopy.next = nodeMap.get(cur.next);
            curCopy.random = nodeMap.get(cur.random);
            cur = cur.next;
        }

        return nodeMap.get(head);
    }
}
