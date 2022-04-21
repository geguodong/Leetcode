# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeElements(self, head: Optional[ListNode], val: int) -> Optional[ListNode]:
        dummy = ListNode(-1, head)
        
        prev = dummy
        cur = head
        
        while cur:
            if cur.val != val:
                prev = cur
                cur = cur.next
                continue
                
            cur = cur.next
            prev.next = cur
            
        return dummy.next
        