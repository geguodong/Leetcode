# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def constructMaximumBinaryTree(self, nums: List[int]) -> Optional[TreeNode]:
        def helper(nums, l, r):
            if l == r:
                return
            
            maxVal = nums[l]
            maxValIdx = l
            for i in range(l, r):
                if nums[i] > maxVal:
                    maxVal = nums[i]
                    maxValIdx = i
                    
            node = TreeNode(maxVal)
            node.left = helper(nums, l, maxValIdx)
            node.right = helper(nums, maxValIdx + 1, r)
            
            return node
        
        return helper(nums, 0, len(nums))