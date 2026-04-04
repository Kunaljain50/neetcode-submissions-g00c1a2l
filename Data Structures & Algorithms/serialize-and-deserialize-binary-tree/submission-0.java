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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode currNode = q.poll();

            if(currNode == null) {
                sb.append("#,");
            } else {
                sb.append(currNode.val).append(",");

                q.add(currNode.left);
                q.add(currNode.right);
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;

        StringBuilder s = new StringBuilder(data);
        String str;
        int commaIdx = s.indexOf(",");
        str = s.substring(0, commaIdx);
        s.delete(0, commaIdx+1);

        TreeNode root = new TreeNode(Integer.parseInt(str));

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode currNode = q.poll();

            commaIdx = s.indexOf(",");
            str = s.substring(0, commaIdx);
            s.delete(0, commaIdx+1);

            if(!str.equals("#")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(str));
                currNode.left = leftNode;
                q.add(leftNode);
            }

            commaIdx = s.indexOf(",");
            str = s.substring(0, commaIdx);
            s.delete(0, commaIdx+1);

            if(!str.equals("#")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(str));
                currNode.right = rightNode;
                q.add(rightNode);
            }
        }

        return root;
    }
}
