/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = nodes.poll();
                if (node != null) {
                    nodes.offer(node.left);
                    nodes.offer(node.right);
                }
            }
            for (int i = 0; i < nodes.size() / 2; ++i) {
                if (((nodes.get(i) == null || nodes.get(nodes.size() - 1 - i) == null)
                        && nodes.get(i) != nodes.get(nodes.size() - 1 - i))
                        || (nodes.get(i) != null && nodes.get(nodes.size() - 1 - i) != null
                                && nodes.get(i).val != nodes.get(nodes.size() - 1 - i).val)) {
                    return false;
                }
            }
        }
        return true;
    }
}