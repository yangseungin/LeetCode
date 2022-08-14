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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> current = new LinkedList<>();
        LinkedList<TreeNode> next = new LinkedList<>();

        current.offer(root);
        List<Integer> list = new ArrayList<>();

        int depth = 0;
        while (!current.isEmpty()) {
            TreeNode tmp = current.poll();

            list.add(tmp.val);

            if (tmp.left != null) {
                next.offer(tmp.left);
            }
            if (tmp.right != null) {
                next.offer(tmp.right);
            }

            if (current.isEmpty()) {
                current = next;
                next = new LinkedList<>();
                if (depth % 2 == 1) {
                    Collections.reverse(list);
                }
                result.add(list);
                list = new ArrayList<>();
                depth++;
            }
        }

        return result;
    }
}