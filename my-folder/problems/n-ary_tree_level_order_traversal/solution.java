/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

// BFS
// O(N) O(N)
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            while (size > 0) {
                size--;
                Node cur = queue.poll();
                level.add(cur.val);
                if(cur.children != null && cur.children.size() != 0) {
                    queue.addAll(cur.children);
                }
            }
            res.add(level);
        }
        return res;
    }
}