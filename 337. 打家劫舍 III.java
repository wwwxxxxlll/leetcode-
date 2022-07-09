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
    Map<TreeNode, Integer> ab = new HashMap<TreeNode, Integer>();
    Map<TreeNode, Integer> noab = new HashMap<TreeNode, Integer>();

    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(ab.getOrDefault(root, 0), noab.getOrDefault(root, 0));
    }

    public void dfs(TreeNode root) {
        if (root == null)
            return;
        dfs(root.left);
        dfs(root.right);
        ab.put(root, Math.max(ab.getOrDefault(root.left, 0), noab.getOrDefault(root.left, 0))
                + Math.max(ab.getOrDefault(root.right, 0), noab.getOrDefault(root.right, 0)));
        noab.put(root, root.val + ab.getOrDefault(root.left, 0) + ab.getOrDefault(root.right, 0));
    }
}