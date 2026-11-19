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
    private Map<Integer, Integer> inorderMap = new HashMap<>();
    private int preorderIdx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIdx = 0;
        for(int i=0; i<inorder.length; i++) inorderMap.put(inorder[i], i);

        return buildDFS(0, inorder.length-1, preorder);
    }

    private TreeNode buildDFS(int left, int right, int[] preorder){
        if(left > right){
            return null;
        }

        int rootVal = preorder[preorderIdx];
        preorderIdx++;

        TreeNode root = new TreeNode(rootVal);
        int rootIdx = inorderMap.get(rootVal);
        root.left = buildDFS(left, rootIdx-1, preorder);
        root.right = buildDFS(rootIdx+1, right, preorder);

        return root;
    }
}
