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
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findMaxSum(root);
        return maxSum;
    }

    private int findMaxSum(TreeNode curNode){
        if(curNode == null){
            return 0;
        }

        int mxLOnePathSum = Math.max(0, findMaxSum(curNode.left));
        int mxROnePathSum = Math.max(0, findMaxSum(curNode.right));

        maxSum = Math.max(maxSum, mxLOnePathSum+mxROnePathSum+curNode.val);

        return Math.max(mxLOnePathSum, mxROnePathSum) + curNode.val;
    }
}
