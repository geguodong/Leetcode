# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def bstFromPreorder(self, preorder: List[int]) -> Optional[TreeNode]:
        def helper(lower, upper):
            nonlocal i
            
            if i == n:
                return
            
            val = preorder[i]
            
            if val < lower or val > upper:
                return
            
            i += 1
            root = TreeNode(val)
            root.left = helper(lower, val)
            root.right = helper(val, upper)
            
            return root
        
        i = 0
        n = len(preorder)
        return helper(-float('inf'), float('inf'))