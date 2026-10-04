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
        //base case: tree 끝에 가면 return
        if(curNode == null){
            return true;
        }

        boolean validLeft;
        boolean validRight;

        if(curNode.val > min && curNode.val < max){
            //now we can update min and max
            //let's look at the left child
            validLeft =dfs(curNode.left, min, curNode.val);
            //right child 
            validRight = dfs(curNode.right, curNode.val, max);
        }else{
            return false;
        }
        
        return validLeft && validRight;
    }

    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
