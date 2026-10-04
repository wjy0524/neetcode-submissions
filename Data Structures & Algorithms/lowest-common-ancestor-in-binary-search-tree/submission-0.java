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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base case: if p q are in the different subtrees meaning one of them is smaller than root and one of them is greater than root then that's a LCA
        //둘다 왼쪽 트리에 있음
        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }else if(p.val > root.val && q.val > root.val){
            //둘다 오른쪽 트리에 있음
            return lowestCommonAncestor(root.right, p, q);
        }else{
            //or 둘중 하나가 root랑 같거나 아니면 다른 트리에 잇으면 그게 LCA
            return root;
        }
    }
}
