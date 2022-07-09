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
    int[] postorder;
    int[] inorder;
    Map<Integer, Integer> inset = new HashMap<Integer, Integer>();

    public TreeNode build(int[] inorder, int is, int ie, int[] postorder, int ps, int pe) {
        if (ie < is || pe < ps)
            return null;
        int val = postorder[pe];
        int index = inset.get(val);
        TreeNode root = new TreeNode(val);
        root.left = build(inorder, is, index - 1, postorder, ps, ps + index - is - 1);
        root.right = build(inorder, index + 1, ie, postorder, ps + index - is, pe - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inset = new HashMap<>();
        this.postorder = postorder;
        this.inorder = inorder;
        for (int i = 0; i < inorder.length; ++i) {
            this.inset.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
}