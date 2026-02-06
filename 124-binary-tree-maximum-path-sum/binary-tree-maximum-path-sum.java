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
    private int result = Integer.MIN_VALUE;
    private int maxSum(TreeNode root) {
        if(root == null) return 0;

        int left = Math.max(0, maxSum(root.left));
        int right = Math.max(0, maxSum(root.right));

        result = Math.max(result, left + right + root.val);

        return root.val + Math.max(left, right);
    }
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return result;
    }
}