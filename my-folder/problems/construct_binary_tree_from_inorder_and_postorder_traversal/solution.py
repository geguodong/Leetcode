# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        inorderMap = {val: idx for idx, val in enumerate(inorder)}
        
        def helper(l, r):
            if l == r:
                return
            
            val = postorder.pop()
            i = inorderMap[val]
            node = TreeNode(val)
            node.right = helper(i + 1, r)
            node.left = helper(l, i)
            
            return node
        
        return helper(0, len(inorder))