# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maximumAverageSubtree(self, root: Optional[TreeNode]) -> float:
        def helper(root):
            nonlocal maxAve
            
            if not root:
                return 0, 0

            leftAve, leftN = helper(root.left)
            rightAve, rightN = helper(root.right)

            ave = (leftAve * leftN + rightAve * rightN + root.val) / (leftN + rightN + 1)
            maxAve = max(maxAve, ave)
            return ave, leftN + rightN + 1
        
        maxAve = 0
        helper(root)
        return maxAve