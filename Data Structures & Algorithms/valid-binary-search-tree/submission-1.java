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

    public boolean dfs(TreeNode curNode, long min, long max){
        //base case if it reached the end(null) return true
        if(curNode == null){
            return true;
        }

        if(min < curNode.val && curNode.val < max){
            //check left Tree 
            return dfs(curNode.left, min, curNode.val) && dfs(curNode.right, curNode.val, max);
        }else{
            return false;
        }
    }
    
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
