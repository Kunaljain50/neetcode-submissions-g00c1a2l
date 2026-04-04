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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();

        int count = 0;
        for(int it : inorder) {
            inMap.put(it, count++);
        }

        return constructTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, inMap);
    }

    public TreeNode constructTree(int[] preorder, int ps, int pe, 
    int[] inorder, int ins, int ine, Map<Integer, Integer> inMap) {

        if(ps > pe || ins > ine) return null;

        TreeNode root = new TreeNode(preorder[ps]);

        int inRoot = inMap.get(preorder[ps]);
        int numsLeft = inRoot - ins;

        root.left = constructTree(preorder, ps + 1, ps + numsLeft,
                             inorder, ins, inRoot - 1, inMap);

        root.right = constructTree(preorder, ps + numsLeft + 1, pe,
                             inorder, inRoot + 1, ine, inMap);

        return root;
    }
}
