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
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val == val) return cur;
            if (cur.val < val) {
                if (cur.right != null) cur = cur.right;
                else return null;
            } else {
                if (cur.left != null) cur = cur.left;
                else return null;
            }
        }
        return null;
    }
}
