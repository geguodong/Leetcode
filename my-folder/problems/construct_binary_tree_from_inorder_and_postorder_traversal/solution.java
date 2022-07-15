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

// HaspMap + Recursion
// O(n) o(n)
class Solution {
    int postorderIndex;
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIndex = postorder.length - 1;
        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        return arrayToTree(postorder, 0, inorder.length - 1);

    }
    
    private TreeNode arrayToTree(int[] postorder, int left, int right) {
        if(left > right) {
            return null;
        }
        
        int val = postorder[postorderIndex--];
        TreeNode root = new TreeNode(val);
        
        root.right = arrayToTree(postorder, map.get(val) + 1, right);
        root.left = arrayToTree(postorder, left, map.get(val) - 1);
        return root;
    }
}