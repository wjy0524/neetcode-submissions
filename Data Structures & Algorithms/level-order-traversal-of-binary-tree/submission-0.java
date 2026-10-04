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
        //ans
        List<List<Integer>> answer = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        if (root == null) return answer;

        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                level.add(curr.val);

                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }

            answer.add(level);

        }

        return answer;


    }
}
