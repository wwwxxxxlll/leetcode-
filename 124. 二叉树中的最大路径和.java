/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int maxs = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathgain(root);
        return maxs;
    }

    public int maxPathgain(TreeNode root) {
        if (root == null)
            return 0;
        int leftgain = Math.max(maxPathgain(root.left), 0);
        int rightgain = Math.max(maxPathgain(root.right), 0);
        int maxsum = leftgain + rightgain + root.val;
        maxs = Math.max(maxs, maxsum);
        return Math.max(leftgain, rightgain) + root.val;
    }
}