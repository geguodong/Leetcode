# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def leafSimilar(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> bool:
        leafSeq1 = self.getLeafSequence(root1)
        leafSeq2 = self.getLeafSequence(root2)
        return leafSeq1 == leafSeq2
        
    def getLeafSequence(self, root):
        res = []
        stack = [root]
        
        while stack:
            cur = stack.pop()
            if not cur.left and not cur.right:
                res.append(cur.val)
            if cur.left:
                stack.append(cur.left)
            if cur.right:
                stack.append(cur.right)
                
        return res