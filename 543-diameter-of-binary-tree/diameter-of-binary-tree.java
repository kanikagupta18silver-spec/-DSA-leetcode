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

    int result = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Height(root);
        return result;
    }

    public int Height(TreeNode root)
    {
        if(root == null) return 0;

        int leftHeight = Height(root.left);
        int rightHeight = Height(root.right);

        result = Math.max(result, leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}