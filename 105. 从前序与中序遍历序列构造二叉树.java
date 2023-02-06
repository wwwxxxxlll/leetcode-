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
    int[] preorder;
    int[] inorder;
    Map<Integer, Integer> inset = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        for (int i = 0; i < inorder.length; ++i) {
            this.inset.put(inorder[i], i);
        }
        return build(0, inorder.length - 1, 0, preorder.length - 1);
    }

    public TreeNode build(int s1, int e1, int s2, int e2) {
        if (s1 > e1 || s2 > e2) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[s1]);
        int inroot = inset.get(preorder[s1]);
        int leftsize = inroot - s2;
        int rightsize = e2 - inroot;
        root.left = build(s1 + 1, s1 + leftsize, s2, inroot - 1);
        root.right = build(s1 + 1 + leftsize, e1, inroot + 1, e2);
        return root;
    }
}