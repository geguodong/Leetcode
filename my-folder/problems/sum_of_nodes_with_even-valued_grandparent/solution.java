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
    static int sum;
    public int sumEvenGrandparent(TreeNode root) {
        sum = 0;
        solve(root, false);
        return sum;
    }
    
    public void solve(TreeNode root, boolean isMyParentEven){
        if(root == null) return;
        
        if(isMyParentEven){
            sum += root.left != null ? root.left.val : 0;
            sum += root.right != null ? root.right.val : 0;
        }
        
        solve(root.left, root.val % 2 == 0);
        solve(root.right, root.val % 2 == 0);
    }
}