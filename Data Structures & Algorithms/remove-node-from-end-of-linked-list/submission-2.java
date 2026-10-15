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
        //slow and fast node로 구하는법
        //fast를 slow보다 n 같 앞에서 시작하기 그러면 fast가 null에 도착하면 slow의 위치가 뒤에서 n 위치임
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy;
        ListNode fast = dummy;

        for(int i=0; i<n; i++){
            fast = fast.next;
        }

        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        //at this point, slow is the node right before the node to be deleted
        slow.next = slow.next.next;

        return dummy.next;
    }
}
