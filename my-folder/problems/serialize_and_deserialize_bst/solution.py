# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:

    def serialize(self, root: Optional[TreeNode]) -> str:
        """Encodes a tree to a single string.
        """
        if not root:
            return ''
        
        res = []
        
        def preOrder(root):
            if not root:
                return
            
            res.append(str(root.val))
            preOrder(root.left)
            preOrder(root.right)
            
        preOrder(root)
        return ','.join(res)

    def deserialize(self, data: str) -> Optional[TreeNode]:
        """Decodes your encoded data to tree.
        """
        if not data:
            return
        
        nums = list(map(int, data.split(',')))
        
        def helper(nums, i, j):
            if i == j:
                return
            
            root = TreeNode(nums[i])
            temp = self.binarySearch(nums, nums[i], i + 1, j)
            root.left = helper(nums, i + 1, temp)
            root.right = helper(nums, temp, j)
            return root
        
        return helper(nums, 0, len(nums))
        
    def binarySearch(self, nums, target, i, j):
        if i == j or nums[i] > target:
            return i
        if nums[j - 1] < target:
            return j
        
        l = i
        r = j
        
        while l < r - 1:
            mid = (l + r) // 2
            if nums[mid] < target:
                l = mid
            else:
                r = mid
                
        return r
        

# Your Codec object will be instantiated and called as such:
# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# tree = ser.serialize(root)
# ans = deser.deserialize(tree)
# return ans