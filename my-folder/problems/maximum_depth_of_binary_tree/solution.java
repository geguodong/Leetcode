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

/*
Time complexity : we visit each node exactly once, thus the time complexity is O(N), where NN is the number of nodes.

Space complexity : in the worst case, the tree is completely unbalanced, e.g. each node has only left child node, the recursion call would occur NN times (the height of the tree), therefore the storage to keep the call stack would be O(N). But in the best case (the tree is completely balanced), the height of the tree would be O(log(N)). Therefore, the space complexity in this case would be O(log(N)).
*/

class Pair {
    TreeNode key;
    Integer value;
    
    public Pair(TreeNode key, Integer value) {
        this.key = key;
        this.value = value;
    }
}
class Solution {
  public int maxDepth(TreeNode root) {
     if(root == null) return 0;
     Queue<Pair> queue = new LinkedList<>();
     queue.add(new Pair(root, 1));
     int maxDepth = 0;
     while(!queue.isEmpty()) {
         Pair pair = queue.poll();
         TreeNode cur = pair.key;
         int depth = pair.value;
         maxDepth = Math.max(maxDepth, depth);
         if(cur.left != null) {
             queue.add(new Pair(cur.left, depth + 1));
         }
         if(cur.right != null) {
             queue.add(new Pair(cur.right, depth + 1));
         }
     }
     return maxDepth;
  }
}