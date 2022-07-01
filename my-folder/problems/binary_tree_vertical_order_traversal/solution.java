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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        
        Map<Integer, List<Integer>> colTable = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        int col = 0;
        int minCol = 0;
        int maxCol = 0;
        queue.add(new Pair(root, col));
        
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            root = pair.getKey();
            col = pair.getValue();
            
            if (root != null) {
                if (!colTable.containsKey(col)) {
                    colTable.put(col, new ArrayList<Integer>());
                }
            }
            colTable.get(col).add(root.val);
            minCol= Math.min(minCol, col);
            maxCol = Math.max(maxCol, col);
            if (root.left != null) {
                queue.add(new Pair(root.left, col - 1));
            }
            if (root.right != null) {
                queue.add(new Pair(root.right, col + 1));
            }
        }
        
        for (int i = minCol; i <= maxCol; i++) {
            res.add(colTable.get(i));
        }
        return res;
    }
}