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
    int maxDiameter;

    public int findMaxDiameter(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftDepth = findMaxDiameter(root.left);
        int rightDepth = findMaxDiameter(root.right);

        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);

        //depth 반환
        return Math.max(leftDepth, rightDepth) + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        findMaxDiameter(root);
        return maxDiameter;
    }

}
