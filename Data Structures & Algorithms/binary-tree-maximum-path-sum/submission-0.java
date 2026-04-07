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
    public int maxPathSum(TreeNode root) {
        int[] maxi = new int[1];

        solution(root, maxi);

        return maxi[0];
    }

    public int solution(TreeNode root, int[] maxi) {
        if (root == null) return 0;

        int lh = solution(root.left, maxi);
        int rh = solution(root.right, maxi);

        maxi[0] = Math.max(maxi[0], root.val + lh + rh);

        return root.val + Math.max(lh, rh);
    }
}
