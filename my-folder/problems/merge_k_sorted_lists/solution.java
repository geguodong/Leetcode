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
/*
Time complexity : O(N\log k)O(Nlogk) where \text{k}k is the number of linked lists.

The comparison cost will be reduced to O(\log k)O(logk) for every pop and insertion to priority queue. But finding the node with the smallest value just costs O(1)O(1) time.
There are NN nodes in the final linked list.
Space complexity :

O(n)O(n) Creating a new linked list costs O(n)O(n) space.
O(k)O(k) The code above present applies in-place method which cost O(1)O(1) space. And the priority queue (often implemented with heaps) costs O(k)O(k) space (it's far less than NN in most situations).
*/
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        
        for(ListNode node: lists){
            if(node != null)
                minHeap.add(node);
        }
        
        ListNode dummy = new ListNode(0), cur = dummy;
        while(!minHeap.isEmpty()){
            ListNode minNode = minHeap.remove();
            cur.next = minNode;
            if(minNode.next != null)
                minHeap.add(minNode.next);
            cur = cur.next;
        }
        return dummy.next;
    }
}