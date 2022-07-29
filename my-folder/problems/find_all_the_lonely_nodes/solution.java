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
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        fun(root, list);
        return list;
    }
    
    void fun(TreeNode root, List<Integer> list) {
        if(root==null) return;
        if(root.left==null && root.right!=null)
        list.add(root.right.val);
        if(root.right==null && root.left!=null)
        list.add(root.left.val);
        fun(root.left, list);
        fun(root.right, list);
    }

}
