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

public class Codec {
    StringBuilder encodedStr;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        encodedStr = new StringBuilder();
        //val#
        preorderEDFS(root);
        return encodedStr.toString();
    }

    private void preorderEDFS(TreeNode root){
        if(root == null){
            //N represents Null
            encodedStr.append("N#");
            return;
        }
        encodedStr.append(Integer.toString(root.val)).append("#");
        preorderEDFS(root.left);
        preorderEDFS(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> q = new ArrayDeque<>(Arrays.asList(data.split("#")));
        return buildDFS(q);
    }

    private TreeNode buildDFS(Deque<String> q){
        String curNodeVal = q.poll();
        if(curNodeVal.equals("N")){
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(curNodeVal));
        root.left = buildDFS(q);
        root.right = buildDFS(q);

        return root;
    }
}
