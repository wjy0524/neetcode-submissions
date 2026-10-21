class Solution {
    int[] memo;

    public int climbStairs(int n) {
        memo = new int[n+1];
        return dfs(n, 0);
    }

    private int dfs(int n, int i){
        if (i>n) return 0;
        if(i==n) return 1;

        if(memo[i]!=0){
            return memo[i];
        }


        memo[i] = dfs(n, i + 1) + dfs(n, i + 2);

        return memo[i];
    }
}
