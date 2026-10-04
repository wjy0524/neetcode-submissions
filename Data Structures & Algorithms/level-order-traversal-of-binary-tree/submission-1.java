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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        if(root == null) return answer;

        q.offer(root);

        while(!q.isEmpty()){
            int levelSize = q.size();
            List<Integer> oneLevel = new ArrayList<>();

            for(int c=0; c<levelSize; c++){
                TreeNode curr = q.poll();
                oneLevel.add(curr.val);

                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }

            answer.add(oneLevel);
        }

        return answer;
    }
}
