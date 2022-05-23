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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<TreeNode> cur = new ArrayList<>();
        List<TreeNode> next = new ArrayList<>();
        cur.add(root);
        List<Integer> list = new ArrayList<>();
        while (!cur.isEmpty()) {
            TreeNode tmp = cur.remove(0);
            list.add(tmp.val);
            if (tmp.left != null) {
                next.add(tmp.left);
            }
            if (tmp.right != null) {
                next.add(tmp.right);
            }

            if (cur.isEmpty()) {
                result.add(list);
                cur = next;

                next = new ArrayList<>();
                list = new ArrayList<>();
            }
        }
        return result;
    }
}