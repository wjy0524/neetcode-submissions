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

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //I guess I have to go through every node so that I can know the length of LinkedList and will find node to be deleted from the start by calculating length of node - n 
        int length = 0;
        ListNode cur = head;
        while(cur != null){
            length++;
            cur = cur.next;
        }

        int location = length - n;
        int cnt = 0;
        ListNode prev = head;
        while(cnt < location-1){
            cnt++;
            prev = prev.next;
        }

        //at this point, prev is pointing the node before node to be deleted
        //head를 삭제해야하는경우
        if(location == 0) return head.next;
        ListNode nxt = prev.next.next;
        //now we should connect prev to next
        prev.next = nxt;
        return head;
    }
}
