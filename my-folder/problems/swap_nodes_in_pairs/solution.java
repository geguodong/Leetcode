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

// Iterator 
// O(N)  O(1)
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head.next;
        
        ListNode prevNode = dummy;
        while(head != null && head.next != null) {
            ListNode firstNode = head;
            ListNode secondNode = head.next;
            
            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            
            prevNode = firstNode;
            head = firstNode.next;
        }
        
        return dummy.next;
    }
}