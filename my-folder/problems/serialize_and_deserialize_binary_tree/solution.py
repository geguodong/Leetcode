# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

import collections

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        if not root:
            return ''
        
        res = []
        
        def preOrder(node):
            if not node:
                res.append('')
                return
            
            res.append(str(node.val))
            preOrder(node.left)
            preOrder(node.right)
            
        preOrder(root)
        return ','.join(res)
        

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        if not data:
            return
        
        def helper(nodes):
            if not nodes[0]:
                nodes.popleft()
                return
            
            root = TreeNode(int(nodes.popleft()))
            root.left = helper(nodes)
            root.right = helper(nodes)
            
            return root
                
        nodes = collections.deque(data.split(','))
        root = helper(nodes)
        return root

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))