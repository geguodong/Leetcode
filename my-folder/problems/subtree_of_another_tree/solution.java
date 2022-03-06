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


class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return bfs(root, subRoot);
    }
    
    boolean bfs(TreeNode r, TreeNode s) {
        if (r != null) {
            Queue<TreeNode> q = new LinkedList();
            q.add(r);
            while(!q.isEmpty()) {
                TreeNode rk = q.poll();
                if (check(rk, s)) return true;
                if (rk.right != null) {
                    q.add(rk.right);
                }
                if (rk.left != null) {
                    q.add(rk.left);
                }        
            }
        }
        return false;
    }
    
    boolean check(TreeNode r, TreeNode s) {
        if (s == null && r == null) return true;
        if (r != null && s != null && r.val == s.val) {
            return check(r.left, s.left) && check(r.right, s.right);
        } else {
            return false;
        }
    }
}