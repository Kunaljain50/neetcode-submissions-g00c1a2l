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
    public TreeNode invertTree(TreeNode root) {
        solution(root);

        return root;
    }

    public static TreeNode solution(TreeNode root) {
        if(root == null) return root;

        TreeNode temp = solution(root.right);
        root.right = solution(root.left);
        root.left = temp;

        return root;
    }
}
