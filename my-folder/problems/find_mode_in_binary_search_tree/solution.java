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
    public void inOrder(TreeNode tree) {
        if (tree != null) {
            inOrder(tree.left);
            list.add(tree.val);
            inOrder(tree.right);
        }
    }
    public int[] findMode(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder(root);
        
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : list) {
            map.put(val, map.getOrDefault(val, 0) + 1);
            if (map.get(val) > max) {
                max = map.get(val);
            }
        }
        
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                res.add(entry.getKey());
            }
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = res.get(i);
        }
        return result;
        
    }
}