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
class FindElements {
    
    TreeNode root;

    public FindElements(TreeNode root) {
        this.root = root;
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        root.val = 0;

        while (!q.isEmpty()){

            int queueSize = q.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode temp = q.peek();

                if (temp.left != null){
                    q.offer(temp.left);
                    temp.left.val = 2* temp.val +1;
                }

                if (temp.right!= null) {
                    q.offer(temp.right);
                    temp.right.val = 2* temp.val +2;
                }
                q.poll();
            }

        }
    }

    public boolean find(int target) {

        return helper(root, target);
       
    }
    public boolean helper(TreeNode rootRec, int target){
        if (rootRec == null) return false;  
        if (rootRec.val == target) return true;
        
        return helper(rootRec.left, target) || helper(rootRec.right, target);
    
    }
}


/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */