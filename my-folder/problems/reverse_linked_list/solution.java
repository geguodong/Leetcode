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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0); // dummy as prev
        ListNode cur = head;
        // ListNode cur2 = new ListrNode(0);
        while (cur != null) {
            ListNode node = new ListNode(cur.val);
            node.next = dummy.next;
            dummy.next = node;
            cur = cur.next;
        }
        return dummy.next;
    }
}