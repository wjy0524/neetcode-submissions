class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length+1];
        int[] ans = new int[2];
        for(int i=1; i<=edges.length; i++){
            parent[i] = i;
        }

        for(int[] edge : edges){
            //check if nodes in the edge are already connected 
            int fNode = edge[0];
            int sNode = edge[1];

            int fParent = find(fNode);
            int sParent = find(sNode);

            if(fParent == sParent){
                ans = edge;
            }else{
                //아니라면 합치기
                union(fParent, sParent);
            }
            
        }

        return ans;

    }

    private void union(int fNode, int sNode){
        parent[sNode] = fNode;
    }

    private int find(int x) {
    // x가 자기 자신의 부모가 될 때까지 parent를 따라 올라가기
    // 그 노드가 x의 그룹 대표
        if(parent[x] == x){
            return x;
        }

        return find(parent[x]);
    }
}
