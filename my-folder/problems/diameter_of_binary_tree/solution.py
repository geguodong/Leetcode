# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        self.diameter = 0
        self.getMaxDepth(root, 0)
        return self.diameter
        
    def getMaxDepth(self, root, depth):
        if not root:
            return -1
        
        ldepth = self.getMaxDepth(root.left, depth + 1)
        rdepth = self.getMaxDepth(root.right, depth + 1)
        
        lpath = max(0, ldepth - depth)
        rpath = max(0, rdepth - depth)
        
        self.diameter = max(self.diameter, lpath + rpath)
        
        return max(depth, ldepth, rdepth)