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
	
    int ans = Integer.MAX_VALUE;
    TreeNode prev = null;
    
    public int minDiffInBST(TreeNode root) {
        solve(root);
        return ans;
    }
    
    void solve(TreeNode root) {
        if(root == null) return;
        solve(root.left);
        if(prev != null) {
            ans = Math.min(ans, Math.abs(root.val - prev.val));
        }
        prev = root;
        solve(root.right);
    }
     
}