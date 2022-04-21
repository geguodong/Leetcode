# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if not head:
            return None
        if not head.next:
            return head
        
        # get num of nodes
        n = 0
        prev = None
        cur = head
        while cur:
            prev = cur
            cur = cur.next
            n += 1
        tail = prev
        k %= n
        
        if k == 0:
            return head
        
        slow = head
        fast = head
        for _ in range(k + 1):
            fast = fast.next
        while fast:
            slow = slow.next
            fast = fast.next
            
        newHead = slow.next
        slow.next = None
        tail.next = head
        
        return newHead