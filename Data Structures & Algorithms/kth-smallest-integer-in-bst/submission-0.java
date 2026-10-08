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
private int counter = 0;
private int answer = 0;
private void inorder(TreeNode node, int k) {
    if (node == null) return;
    inorder(node.left, k);   // 1. 왼쪽 먼저
    // 2. 나: count를 올리고, k번째면 answer에 저장
    counter++;
    if(counter == k) answer = node.val;
    inorder(node.right, k);  // 3. 오른쪽
}

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return answer;
    }
}
