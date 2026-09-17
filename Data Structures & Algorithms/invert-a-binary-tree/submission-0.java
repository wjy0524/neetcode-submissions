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
        //leaf nodes 갈때까지
        if(root == null){
            return null;
        }

        //tree swap leftchild with rightchild
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        //go deeper
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
