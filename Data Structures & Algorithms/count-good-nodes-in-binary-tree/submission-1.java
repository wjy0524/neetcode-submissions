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
    int cnt = 0;

    public void findGoodNodes(TreeNode curNode, int curMax){
        //base case: when curNod is null return meaning it reached the end 
        if(curNode == null){
            return;
        }

        //compare teh curNode's max with curMax
        if(curNode.val < curMax){
            findGoodNodes(curNode.left, curMax);
            findGoodNodes(curNode.right, curMax);
        }else{
            cnt++;
            findGoodNodes(curNode.left, Math.max(curMax, curNode.val));
            findGoodNodes(curNode.right, Math.max(curMax, curNode.val));
        }


    }
    public int goodNodes(TreeNode root) {
        findGoodNodes(root, root.val);
        return cnt;
    }
}
