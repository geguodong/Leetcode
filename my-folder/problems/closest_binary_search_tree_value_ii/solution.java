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

// Recursion Inorder + Heap 
// O(NlogK)   O(K + H)
class Solution {
    public void inorder(TreeNode r, Queue<Integer> heap, int k) {
        if (r == null) 
            return;
                    
        inorder(r.left, heap, k);
        heap.add(r.val);
        if (heap.size() > k) 
            heap.remove();
        inorder(r.right, heap, k);
    }

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        
        // init heap 'less close element first'
        Queue<Integer> heap = new PriorityQueue<>((o1, o2) -> Math.abs(o1 - target) > Math.abs(o2 - target) ? -1 : 1);
        inorder(root, heap, k);
        return new ArrayList<>(heap);
    }
}