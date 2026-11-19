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
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findMaxPathSum(root);

        return maxSum;
    }

    private int findMaxPathSum(TreeNode curNode){
        if(curNode == null){
            return 0;
        }

        //각 노드에서 해야할 것 3가지
        // 2. 왼쪽, 오른쪽 자식에게서 한쪽 경로 최대 합 받아오기
        //    단, 음수면 안 가져가는 게 이득 → 0과 비교해서 큰 값 사용
        int mxLOnePathSum = Math.max(0, findMaxPathSum(curNode.left));
        int mxROnePathSum = Math.max(0, findMaxPathSum(curNode.right));

        // 3. 이 노드에서 '꺾이는' 경로로 전역 최댓값 갱신
        //    (왼쪽 + 현재 값 + 오른쪽)
        maxSum = Math.max(maxSum, mxLOnePathSum+mxROnePathSum+curNode.val);

        // 4. 부모에게는 꺾지 않은 경로만 반환
        //    (현재 값 + 왼쪽과 오른쪽 중 큰 쪽)
        return curNode.val + Math.max(mxLOnePathSum, mxROnePathSum);
    }
}
