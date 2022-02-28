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
Let NN be the number of nodes in the tree.

Time complexity : O(N)O(N).

Each node is put onto the stack once, by its parent node. We know each node only has one parent because this is a tree. Therefore, each node is only taken off, and processed, once. Processing a node is an O(1) operation. Therefore, we get a total time complexity of N N⋅O(1)=O(N).

Space complexity : O(N).

Remember that in complexity analysis, we're always looking at the worst case. The worst-case tree is one where we have a long "strand" of left nodes, with each having a single right node. On one of these trees, the algorithm will work its way down the left nodes first, having at most one of them on the stack at a time. However, every right node that it encounters will be placed on the stack. With half of the nodes being these right nodes, the space used is proportional to the number of nodes in the tree, giving us a space complexity of O(N).

For the problem we've been given here on LeetCode, we haven't been told whether or not the input tree is balanced (most non-leaf nodes having 2 children, thus minimizing the maximum depth). Therefore, we have to assume it is not. However, in an interview, you might be asked what the time and space complexity are if the input was guaranteed to be a balanced tree. If it is, balanced, then the time complexity remains the same (we still have to visit all NN nodes), but the space complexity becomes O(D), where DD is the maximum depth. This is equivalent to O(logN).

*/
class Solution { 
    
  private boolean isLeaf(TreeNode node) {
    return node != null && node.left == null && node.right == null;
  }

  public int sumOfLeftLeaves(TreeNode root) {

    if (root == null) {
      return 0;
    }

    int total = 0;
    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      TreeNode subRoot = stack.pop();
      // Check if the left node is a leaf node.
      if (isLeaf(subRoot.left)) {
        total += subRoot.left.val;
      }
      // If the right node exists, put it on the stack.
      if (subRoot.right != null) {    
        stack.push(subRoot.right);
      }
      // If the left node exists, put it on the stack.
      if (subRoot.left != null) {
        stack.push(subRoot.left);
      }
    }

    return total;
  }
}