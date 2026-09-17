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
    public TreeNode invertTree(TreeNode root) {
        //base case
        //when it reached the leaf node 
        //meaning if the root is null meaning root's parent node is leaf node 
        if(root == null){
            return null;
        }

        //swap left child with right child
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        //after swapping go deeper
        invertTree(root.left);
        invertTree(root.right);

        //return root
        return root;
    }
}
