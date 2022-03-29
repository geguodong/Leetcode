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
	List<Integer> list = new ArrayList<>();
    
    public List<Integer> getLonelyNodes(TreeNode root) {
        fun(root);
        return list;
	}
    
	void fun(TreeNode root) {
		if(root==null) return;
		fun(root.left);
		fun(root.right);

		if(root.left==null && root.right!=null)
			list.add(root.right.val);
		if(root.right==null && root.left!=null)
			list.add(root.left.val);
	}

}