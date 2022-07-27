public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> ser = new ArrayList<>();
        rserialize(root, ser);
        return ser.toString();
    }
    
    private void rserialize(TreeNode root, List<Integer> ser) {
        if ( root == null ) {
            ser.add(null);
        } else {
            ser.add(root.val);
            rserialize(root.left, ser);
            rserialize(root.right, ser);
        }
    } 

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArray = data.substring(1, data.length() - 1).split(", ");
        List<String> dataList = new LinkedList<String>(Arrays.asList(dataArray));
        return rdeserialize(dataList);
    }
    
    private TreeNode rdeserialize(List<String> l) {
        if ( l.get(0).equals("null") ) {
            l.remove(0);
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left = rdeserialize(l);
        root.right = rdeserialize(l);
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));