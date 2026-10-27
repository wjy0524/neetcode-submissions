class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //n gas stations along a circular route
        int n = gas.length;

        int gasBalance = 0;
        int total = 0;
        int resultIdx = 0;

        for(int i=0; i<n; i++){
            gasBalance += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if(gasBalance < 0){
                gasBalance = 0;
                resultIdx = i+1;
            }
        }
        if(total < 0) return -1;
        return resultIdx;
    }
}
