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
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if(head == null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode Prev = dummy;
        
        for(int i = 1; i < left; i++){
            Prev = Prev.next;
        }

        ListNode Curr = Prev.next;

        for(int i = 0; i < right - left; i++){
            ListNode Next = Curr.next;
            Curr.next = Next.next;
            Next.next = Prev.next;
            Prev.next = Next;
        }

        return dummy.next;
    }
}