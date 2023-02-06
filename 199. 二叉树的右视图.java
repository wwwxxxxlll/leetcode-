// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class Solution {
//     public List<Integer> rightSideView(TreeNode root) {
//         List<Integer> ans = new ArrayList<Integer>();
//         Stack<TreeNode> nodeque = new Stack<TreeNode>();
//         Stack<Integer> depthque = new Stack<Integer>();
//         HashMap<Integer,Integer> rightval = new HashMap<>();
//         int max_depth = 0;
//         depthque.push(0);
//         nodeque.push(root);
//         while(!nodeque.isEmpty()){
//             int depth = depthque.pop();
//             TreeNode node = nodeque.pop();
//             if(node!=null){
//                 max_depth = Math.max(max_depth,depth);
//                 if(!rightval.containsKey(depth))
//                     rightval.put(depth,node.val);
//                 depthque.push(depth+1);
//                 depthque.push(depth+1);
//                 nodeque.push(node.left);
//                 nodeque.push(node.right);
//             }
//         }
//         for (int depth = 0; depth <= max_depth; depth++) {
//             if(rightval.containsKey(depth))
//                 ans.add(rightval.get(depth));
//         }
//         return ans;
//     }
// }
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
    public List<Integer> rightSideView(TreeNode root) {
        Deque<TreeNode> nodes = new LinkedList<TreeNode>();
        List<Integer> ans = new ArrayList<Integer>();
        if (root == null)
            return ans;
        nodes.push(root);
        boolean thislevel = false;
        int cnt = 0;
        while (!nodes.isEmpty()) {
            thislevel = false;
            cnt = nodes.size();
            for (int i = 0; i < cnt; ++i) {
                TreeNode node = nodes.pop();
                if (i == cnt - 1) {
                    ans.add(node.val);
                }
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
        }
        return ans;
    }
}