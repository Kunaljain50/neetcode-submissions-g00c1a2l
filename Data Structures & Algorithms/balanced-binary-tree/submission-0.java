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
    private static boolean isBalanced;
    public boolean isBalanced(TreeNode root) {
        isBalanced = true;
        height(root);

        return isBalanced;
    }

    public static int height(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        if(lh - rh > 1) {
            isBalanced = false;
        }

        return 1 + Math.max(lh, rh);
    }
}
