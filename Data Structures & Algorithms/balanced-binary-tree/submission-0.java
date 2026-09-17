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
    boolean isBala = true;
    public int findBalanced(TreeNode root){
        if(isBala == false){
            return 0;
        }

        if(root == null){
            return 0;
        }

        //leftDepth
        int leftDepth = findBalanced(root.left);
        int rightDepth = findBalanced(root.right);

        if(Math.abs(leftDepth - rightDepth) > 1){
            isBala = false;
            return 0;
        }
        return Math.max(leftDepth, rightDepth)+1;
    }
    public boolean isBalanced(TreeNode root) {
        //recursively 각각의 노드에서 height-balanced인지 확인해야할듯
        int depth = findBalanced(root);
        return isBala;
    }
}
