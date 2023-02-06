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
    boolean ans = true;

    public boolean isBalanced(TreeNode root) {
        heights(root);
        return ans;
    }

    public int heights(TreeNode root) {
        if (root == null || ans == false) {
            return 0;
        }
        int left = heights(root.left) + 1;
        int right = heights(root.right) + 1;
        if (Math.abs(left - right) > 1) {
            ans = false;
            return 0;
        }
        return Math.max(right, left);
    }
}