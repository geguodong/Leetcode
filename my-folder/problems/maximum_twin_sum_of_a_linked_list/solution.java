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
    public int pairSum(ListNode head) {
        // reverse the first half and calculate the sum of each twin nodes
        ListNode dummyHead = new ListNode(); // dummHead.next will point to the head of the reversed first half
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            
            // add slow node into the reversed node;
            ListNode newSlow = slow.next;
            slow.next = dummyHead.next;
            dummyHead.next = slow;
            slow = newSlow;
            
        }
        
        int maxSum = -1;
        ListNode reversed = dummyHead.next;
        while(slow != null) {
            int sum = slow.val + reversed.val;
            maxSum = Math.max(maxSum, sum);
            slow = slow.next;
            reversed = reversed.next;
        }
        
        return maxSum;
    }
}