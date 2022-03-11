/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode ptr = node;
        while (ptr.next != null) {
            ptr.val = ptr.next.val;
            if (ptr.next.next == null) {
                ptr.next = null;
                return;
            }
            ptr = ptr.next;
        }
        return;
    }
}