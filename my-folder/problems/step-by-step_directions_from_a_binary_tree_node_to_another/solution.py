# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def getDirections(self, root: Optional[TreeNode], startValue: int, destValue: int) -> str:
        startPath = []
        self.findTarget(root, startValue, startPath)
        destPath = []
        self.findTarget(root, destValue, destPath)
        
        i = 0
        while i < len(startPath) and i < len(destPath):
            if startPath[i] != destPath[i]:
                break
            i += 1
            
        return ''.join(['U'] * (len(startPath) - i) + destPath[i:len(destPath)])
        
    def findTarget(self, root, target, path):
        if not root:
            return False
        
        if root.val == target:
            return True
        
        path.append('L')
        if self.findTarget(root.left, target, path):
            return True
        path.pop()
        
        path.append('R')
        if self.findTarget(root.right, target, path):
            return True
        path.pop()
        
        return False