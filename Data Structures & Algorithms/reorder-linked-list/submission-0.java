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

    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;

    }

    public void reorderList(ListNode head) {
        //[0, n-1, 1, n-2, 2, n-3, ...]
        //이거 언제 까지 반복? mid 까지
        //then have to find mid 
        //use two pointers(slow and fast)
        //slow pointer가 한칸 될때 fast pointer는 두칸
        
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }


        ListNode secondHalf = reverse(slow.next);
        slow.next = null;

        ListNode firstHalf = head;

        while(secondHalf != null){
            ListNode temp1 = firstHalf.next;
            ListNode temp2 = secondHalf.next;
        
            firstHalf.next = secondHalf;
            secondHalf.next = temp1;
        
            firstHalf = temp1;
            secondHalf = temp2;
        }

        return;
        
    }
}
