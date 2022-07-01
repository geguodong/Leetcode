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
    public int findBottomLeftValue(TreeNode root) {
        int[] result = {1, root.val}; // The first element is current depth, last is the root.val
        search(root, result, 1);
        return result[1];
    }
    
    public static void search(TreeNode root, int[] result, int depth) {
        if (root == null) {
            return;
        }
        if (depth > result[0]) { // This ensures the last row get the priority
            result[0] = depth;
            result[1] = root.val;
        }
        search(root.left, result, depth+1); // We always want the left most answer
        search(root.right, result, depth+1); // if not left, right is the left most answer
    }
}