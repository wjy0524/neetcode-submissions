class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        //n is the number of nodes
        int n = edges.length + 1;

        //initialize the parent
        parent = new int[n+1];
        //initialize all the node's parent as itself
        for(int i=1; i<=n; i++) parent[i] = i;

        int[] ans = new int[2];

        for(int[] edge : edges){
            int fNode = edge[0];
            int sNode = edge[1];

            int fParent = findParent(fNode);
            int sParent = findParent(sNode);
            if(fParent == sParent){
                //then it's already connected
                ans = edge;
            }else{
                union(fParent, sParent);
            }
        }
        return ans;
    }

    private int findParent(int node){
        if(parent[node] == node){
            return node;
        }

        return findParent(parent[node]);
    }

    private void union(int fRoot, int sRoot){
        parent[sRoot] = fRoot;
    }
}
