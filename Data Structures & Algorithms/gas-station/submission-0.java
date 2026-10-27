class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //n gas stations along a circular route
        int n = gas.length;
        //two integer arrays gas and cost 
        if(Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) return -1;

        //at this point, there's at least one way
        int gasBalance = 0;
        int resultIdx =0;

        for(int i=0; i<n; i++){
            gasBalance += gas[i] - cost[i];
            if(gasBalance < 0){
                gasBalance = 0;
                resultIdx = i+1;
            }
        }

        return resultIdx;
    }
}
