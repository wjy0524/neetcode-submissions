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
    public int findGoodNodes(TreeNode curNode, int curMax){
        //base case: when curNod is null return meaning it reached the end 
        if(curNode == null){
            return 0;
        }

        //compare teh curNode's max with curMax
        if(curNode.val < curMax){
            return findGoodNodes(curNode.left, curMax) + findGoodNodes(curNode.right, curMax);
        }else{
            return 1 + findGoodNodes(curNode.left, curNode.val) + findGoodNodes(curNode.right, curNode.val);
        }


    }
    public int goodNodes(TreeNode root) {
        return findGoodNodes(root, root.val);
    }
}
