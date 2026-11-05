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
        //hash Map
        //key: original node, value: copied node
        Map<Node, Node> copied = new HashMap<>();

        //복사 만들기 끝
        Node cur1 = head;
        while(cur1 != null){
            Node copyNode = new Node(cur1.val);
            copied.put(cur1, copyNode);
            cur1 = cur1.next;
        } 

        //연결 파트
        Node cur2 = head;
        while(cur2 != null){
            Node curCopied = copied.get(cur2);
            curCopied.next = copied.get(cur2.next);
            curCopied.random = copied.get(cur2.random);
            cur2 = cur2.next;
        }

        return copied.get(head);

    }
}
