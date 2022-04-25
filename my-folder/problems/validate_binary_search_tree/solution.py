# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        
        def helper(root, lower, upper):
            if not root:
                return True
            
            return lower < root.val < upper \
                    and helper(root.left, lower, root.val) \
                    and helper(root.right, root.val, upper)
        
        return helper(root, -float('inf'), float('inf'))