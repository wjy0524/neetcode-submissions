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
    private int cnt = 0;
    private int answer = 0;

    private void inorder(TreeNode cur, int k){
        if(cur == null) return;
        //왼쪽 부터
        inorder(cur.left, k);
        //본인 체크
        cnt++;
        if(cnt == k) answer = cur.val;
        //오른쪽 체크
        inorder(cur.right, k);
    }
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return answer;
    }
}
