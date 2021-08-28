/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// Time complexity : O(N), where N is a number of nodes in the tree, since one visits each node exactly once.

// Space complexity : O(log(N)) in the best case of completely balanced tree and O(N) in the worst case of completely unbalanced tree, to keep a recursion stack.
// class Solution {
//     public boolean isSameTree(TreeNode p, TreeNode q) {
//         if (p == null && q == null) return true;
//         if (p == null || q ==null || p.val != q.val) {
//             return false;
//         } else return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
//     }
// }


class Solution {
    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return true;
    }
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (!check(p, q)) return false;
        
        ArrayDeque<TreeNode> deqP = new ArrayDeque<>();
        ArrayDeque<TreeNode> deqQ = new ArrayDeque<>();
        
        deqP.addLast(p);
        deqQ.addLast(q);
        
        while (!deqP.isEmpty()) {
          p = deqP.removeFirst();
          q = deqQ.removeFirst();

          if (!check(p, q)) return false;
          if (p != null) {
            // in Java nulls are not allowed in Deque
            if (!check(p.left, q.left)) return false;
            if (p.left != null) {
              deqP.addLast(p.left);
              deqQ.addLast(q.left);
            }
            if (!check(p.right, q.right)) return false;
            if (p.right != null) {
              deqP.addLast(p.right);
              deqQ.addLast(q.right);
            }
          }
        }
        return true;    
    }
}
