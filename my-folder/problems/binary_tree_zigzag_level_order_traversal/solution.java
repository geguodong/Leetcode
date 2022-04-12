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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>> ();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer (root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) { 
                TreeNode pollNode = queue.poll();
                list.add(pollNode.val);
                if (pollNode.left != null) {
                    queue.offer(pollNode.left);
                }
                if (pollNode.right != null) {
                    queue.offer(pollNode.right);
                }
            }
            level++;
            if (level % 2 == 0) Collections.reverse(list);
            result.add(list);
        }

        return result;
    }
}


