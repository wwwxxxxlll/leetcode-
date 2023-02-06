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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        inorder(ans, root);
        return ans;
    }

    public void inorder(List<Integer> l, TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(l, root.left);
        l.add(root.val);
        inorder(l, root.right);
    }
}