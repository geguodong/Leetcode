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

// DFS
// O(N) O(N)
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        //bfs(res,root);
        dfs(res, root, 0);
        return res;
    }
    private void dfs(List<Integer> list, TreeNode node, int level){
        if(node == null) return;
        if(list.size() == level) list.add(node.val);
        if(list.get(level) < node.val){
            list.set(level, node.val);
        }
        dfs(list, node.left, level+1);
        dfs(list, node.right, level+1);
    }
    private void bfs(List<Integer> list, TreeNode root){
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < size; i++){
                TreeNode node = queue.remove();
                max = Math.max(max, node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            list.add(max);
        }
    }
}