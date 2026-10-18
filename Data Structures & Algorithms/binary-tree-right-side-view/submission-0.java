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
    public List<Integer> rightSideView(TreeNode root) {
        //answer arrayList
        List<Integer> result = new ArrayList<>();
        //if the root is null, then it should return empty right away
        if(root == null) return result;

        //I can use BFS
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0; i<size; i++){
                TreeNode child = q.poll();

                //같은 레벨의 마지막 아이만 추가한다
                if(i == size-1) result.add(child.val);

                //그리고 그 밑에 자식들 넣어야지 null아니
                if(child.left != null) q.offer(child.left);
                if(child.right != null) q.offer(child.right);
            
            }
        }

        //계속 돌리고 나오면 result에는 각 레벨당 마지막 노드만 남아있음
        return result;

    }
}
