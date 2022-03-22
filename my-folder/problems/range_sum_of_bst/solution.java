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
    int sum;
    public int rangeSumBST(TreeNode root, int low, int high) {
        sum = 0;
        sumNode(root, low, high);
        return sum;
    }
    
    public void sumNode(TreeNode node, int low, int high) {
        if (node == null) return;
        if (node.val >= low && node.val <= high) {
            sum += node.val;
        }
        if (node.val > low) {
            sumNode(node.left, low, high);
        } 
        if (node.val < high) {
            sumNode(node.right, low, high);
        }
       
    }
}