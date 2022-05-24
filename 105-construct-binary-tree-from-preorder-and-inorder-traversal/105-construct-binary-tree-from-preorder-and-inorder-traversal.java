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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
          return dfs(0, 0, inorder.length - 1, preorder, inorder);
    }
    private  TreeNode dfs(int preorderIndex, int inorderStart, int inorderEnd, int[] preorder, int[] inorder) {
        if (preorderIndex > preorder.length - 1 || inorderStart > inorderEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preorderIndex]);

        int inorderIndex = 0;
        for (int i = inorderStart; i <= inorderEnd; i++) {
            if (inorder[i] == root.val) {
                inorderIndex = i;
                break;
            }
        }
//        왼쪽 set
        root.left = dfs(preorderIndex + 1, inorderStart, inorderIndex - 1, preorder, inorder);
//        오른쪾 set
        root.right = dfs(preorderIndex + inorderIndex - inorderStart + 1, inorderIndex + 1, inorderEnd, preorder, inorder);

        return root;
    }
}