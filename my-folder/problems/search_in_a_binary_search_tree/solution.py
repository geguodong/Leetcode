# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def searchBST(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        cur = root
        while cur:
            if val == cur.val:
                return cur
            
            if val < cur.val:
                cur = cur.left
            else:
                cur = cur.right
                
        return cur