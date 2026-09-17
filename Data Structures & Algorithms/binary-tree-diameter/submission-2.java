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

        //현재 노드에서의 최대 길이는
        //leftDepth + rightDepth
        int leftDepth = findMaxDiameter(root.left);
        int rightDepth = findMaxDiameter(root.right);

        int diameter = leftDepth + rightDepth;

        maxDiameter = Math.max(maxDiameter, diameter);

        //현재 node에서의 depth 반영
        //+1은 현재 노드로 인해 depth increments by1 
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        findMaxDiameter(root);
        return maxDiameter;
    }
}
