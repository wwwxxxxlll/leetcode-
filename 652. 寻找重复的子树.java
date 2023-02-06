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
    HashMap<String, Integer> subtrees = new HashMap<String, Integer>();
    ArrayList<TreeNode> result = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return result;
    }

    public String dfs(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder str = new StringBuilder();
        str = str.append(root.val);
        str = str.append("/");
        str = str.append(dfs(root.left));
        str = str.append("/");
        str = str.append(dfs(root.right));
        String key = str.toString();
        if (subtrees.getOrDefault(key, 0) == 1) {
            result.add(root);
        }
        subtrees.put(key, subtrees.getOrDefault(key, 0) + 1);
        return str.toString();
    }

}