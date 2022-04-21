# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head:
            return None
        
        if not head.next:
            return head
        
        dummy = ListNode(101, head)
        prev = dummy
        cur = head
        
        while cur and cur.next:
            if cur.val != cur.next.val:
                prev = cur
                cur = cur.next
                continue
            
            val = cur.val
            while cur and cur.val == val:
                cur = cur.next
            prev.next = cur
            
        return dummy.next